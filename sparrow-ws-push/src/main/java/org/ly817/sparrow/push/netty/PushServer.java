package org.ly817.sparrow.push.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.ly817.sparrow.api.feign.FAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


/**
 * Created by LuoYu on 2019/11/15.
 */
@Component("pushServer")
public class PushServer {

    private final Logger logger = LoggerFactory.getLogger(PushServer.class);

    @Autowired
    private PushWebSocketHandler pushWebSocketHandler;

    @Value("${cmd.push.port}")
    public Integer port;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 启动netty服务
     */
    public void start(){
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss,worker).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast("logging",new LoggingHandler("DEBUG"));
                        // 解码器 设置为HttpServerCodec：将请求和应答消息解码为HTTP消息
                        socketChannel.pipeline().addLast("http-codec",new HttpServerCodec());
                        // 聚合器 HttpObjectAggregator：将HTTP消息的多个部分合成一条完整的HTTP消息
                        socketChannel.pipeline().addLast("aggregator",new HttpObjectAggregator(65536));
                        // 用于大数据的分区传输 ChunkedWriteHandler
                        socketChannel.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
                        // 进行设置心跳检测
                        socketChannel.pipeline().addLast(new IdleStateHandler(60,30,60*30, TimeUnit.SECONDS));
                        // 配置通道处理  来进行业务处理
                        socketChannel.pipeline().addLast(pushWebSocketHandler);

                    }
                }).option(ChannelOption.SO_BACKLOG,1024)
                .childOption(ChannelOption.SO_KEEPALIVE,true);

        try {
            Channel channel = bootstrap.bind(port).sync().channel();
            channel.closeFuture().sync();
            logger.info("PushServer 启动成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }
}
