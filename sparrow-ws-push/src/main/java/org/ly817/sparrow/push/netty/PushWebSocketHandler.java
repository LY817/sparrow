package org.ly817.sparrow.push.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.AttributeKey;
import io.netty.util.CharsetUtil;

import org.ly817.sparrow.api.pojo.User;
import org.ly817.sparrow.api.service.IAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by LuoYu on 2019/11/16.
 */
@Component
public class PushWebSocketHandler extends SimpleChannelInboundHandler<Object> {

    private final Logger logger = LoggerFactory.getLogger(PushWebSocketHandler.class);

    private static final String URI = "push";

    private WebSocketServerHandshaker handshaker;

    @Autowired
    private IAdminService adminService;

    /**
     * 客户端连接上服务时，注册到PushClientCenter
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        PushClientCenter.addClient(ctx.channel());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        PushClientCenter.addClient(ctx.channel());
    }

    /**
     * 客户端断开连接，PushClientCenter注销
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        PushClientCenter.removeClient(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        PushClientCenter.removeClient(ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.channel().close();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    /**
     * WebSocket消息处理
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent stateEvent = (IdleStateEvent) evt;
            PingWebSocketFrame ping = new PingWebSocketFrame();
            switch (stateEvent.state()) {
                //读空闲（服务器端）
                case READER_IDLE:
                    logger.info("【" + ctx.channel().remoteAddress() + "】读空闲（服务器端）");
                    ctx.writeAndFlush(ping);
                    break;
                //写空闲（客户端）
                case WRITER_IDLE:
                    logger.info("【" + ctx.channel().remoteAddress() + "】写空闲（客户端）");
                    ctx.writeAndFlush(ping);
                    break;
                case ALL_IDLE:
                    logger.info("【" + ctx.channel().remoteAddress() + "】读写空闲");
                    break;
            }
        }
    }

    /**
     * 处理连接的请求
     * http握手请求和WebSocket frame
     */
    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            doHandlerHttpRequest(ctx, (HttpRequest) msg);
        } else if (msg instanceof WebSocketFrame) {
            doHandlerWebSocketFrame(ctx, (WebSocketFrame) msg);
        }
    }

    /**
     * websocket消息处理
     *
     * @param ctx
     * @param msg
     */
    private void doHandlerWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame msg) {
        //判断msg 是哪一种类型  分别做出不同的响应

        // 判断是否关闭链路的指令
        if (msg instanceof CloseWebSocketFrame) {
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) msg);
            return;
        }

        // 如果是ping消息 响应pong消息
        if (msg instanceof PingWebSocketFrame) {
            PongWebSocketFrame pong = new PongWebSocketFrame(msg.content().retain());
            ctx.channel().writeAndFlush(pong);
            return;
        }

        // 如果是pong消息 响应ping消息
        if (msg instanceof PongWebSocketFrame) {
            PingWebSocketFrame ping = new PingWebSocketFrame(msg.content().retain());
            ctx.channel().writeAndFlush(ping);
            return;
        }
        if (!(msg instanceof TextWebSocketFrame)) {
            logger.info("【不支持二进制】");
            throw new UnsupportedOperationException("不支持二进制");
        }

        //可以对消息进行处理
        //群发
        for (Channel channel : PushClientCenter.globalChannels) {
            channel.writeAndFlush(new TextWebSocketFrame(((TextWebSocketFrame) msg).text()));
        }

    }


    /**
     * wetsocket第一次连接http握手
     * <p>
     * todo 解析url获取用户登陆信息 通过rest接口获取的token
     *
     * @param ctx
     * @param req
     */
    private void doHandlerHttpRequest(ChannelHandlerContext ctx, HttpRequest req) {
        // http 解码失败
        if (!req.decoderResult().isSuccess() || (!"websocket".equals(req.headers().get("Upgrade")))) {
            sendHttpResponse(ctx, (FullHttpRequest) req, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
        }
        //可以获取msg的uri来判断
        String uri = req.uri();
        if (!uri.substring(1).equals(URI)) {
            // TODO: 2019/11/17 根据不同的uri 对应不同的处理逻辑
            String[] uriInfos = uri.split("/");
            String token = uriInfos[3];
            String userName = uriInfos[2];
            User user = adminService.auth(userName,token);
            if (user == null) {
                ctx.close();
            } else {
                // 用户信息和channel注册到PushClientCenter
                PushClientCenter.registerUserChannelId(user.getUserId() + "",ctx.channel().id());
            }
        }
        ctx.attr(AttributeKey.valueOf("type")).set(uri);
        //可以通过url获取其他参数
        WebSocketServerHandshakerFactory factory = new WebSocketServerHandshakerFactory(
                "ws://" + req.headers().get("Host") + "/" + URI + "", null, false
        );
        handshaker = factory.newHandshaker(req);
        if (handshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        } else {
            //进行连接
            handshaker.handshake(ctx.channel(), (FullHttpRequest) req);
            //可以做其他处理
        }
    }

    private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, DefaultFullHttpResponse res) {
        // 返回应答给客户端
        if (res.getStatus().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(res.getStatus().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
        }
        // 如果是非Keep-Alive，关闭连接
        ChannelFuture f = ctx.channel().writeAndFlush(res);
        if (!HttpHeaders.isKeepAlive(req) || res.getStatus().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.debug("message accepted {}", msg);
        this.messageReceived(ctx, msg);
    }
}
