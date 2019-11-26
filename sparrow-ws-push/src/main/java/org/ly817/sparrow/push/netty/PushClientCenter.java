package org.ly817.sparrow.push.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.ly817.sparrow.api.enums.APIExceptionType;
import org.ly817.sparrow.api.exception.APIException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by LuoYu on 2019/11/16.
 *
 * 维护连接到服务端的客户端连接 static作为运行时全局变量
 *
 * 执行消息的分发逻辑
 *
 * 消息的群发和指定发
 * - todo 添加group与业务逻辑
 *
 */
public class PushClientCenter {

    /**
     * ChannelGroup是netty提供用于管理web于服务器建立的通道channel的，其本质是一个高度封装的set集合
     * 在服务器广播消息时，可以直接通过它的writeAndFlush将消息发送给集合中的所有通道中去。
     * 但在查找某一个客户端的通道时候比较坑爹，必须通过channelId对象去查找，而channelId不能人为创建，所有必须通过map将channelId的字符串和channel保存起来
     */
    public static ChannelGroup globalChannels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 分组群发
     * 根据不同的业务分组
     */
    public static Map<String,ChannelGroup> unitChannelGroupMapping = new ConcurrentHashMap<>();

    /**
     * 维护userId-channelId对应关系
     * 方便通过userId在globalChannels中获取客户端连接
     */
    public static Map<String,ChannelId> userChannelIdMapping = new ConcurrentHashMap<>();

    /**
     * 添加连接到globalChannels
     * @param clientChannel
     */
    public static boolean addClient(Channel clientChannel) {
        return globalChannels.add(clientChannel);
    }

    /**
     * 从globalChannels中删除连接
     * @param clientChannel
     */
    public static boolean removeClient(Channel clientChannel){
        return globalChannels.remove(clientChannel);
    }

    /**
     * 注册userId-channelId对应关系
     */
    public static void registerUserChannelId(String userId,ChannelId channelId){
        userChannelIdMapping.put(userId,channelId);
    }

    /**
     * 注销userId-channelId对应关系
     */
    public static void removeUserChannelId(String userId){
        userChannelIdMapping.remove(userId);
    }

    /**
     * 根据userId获取连接
     * @param userId
     */
    private static Channel findChannelByUserId(String userId){
        ChannelId channelId = userChannelIdMapping.get(userId);
        if (channelId != null) {
            return globalChannels.find(channelId);
        } else {
            return null;
        }
    }

    private static void removeChannelByUserId(String userId){
        Channel channel = findChannelByUserId(userId);
        if (channel != null) {
            // 注销userId-channelId对应关系
            removeUserChannelId(userId);

            removeClient(channel);
        }
    }

    public static void sendMsgByUserId(String userId,String msg){
        Channel channel = findChannelByUserId(userId);
        if (channel != null) {
            channel.writeAndFlush(new TextWebSocketFrame(msg));
        } else {
            throw new APIException(APIExceptionType.PUSH_USER_NOT_ONLINE);
        }
    }

    /**
     * 全部连接进行广播
     */
    public static void globalBroadcasting(String msg){
        globalChannels.writeAndFlush(new TextWebSocketFrame(msg));
    }

    /**
     * 将连接注册到对应的业务分组
     * @param unitId
     * @param channel
     */
    public static void registerChannelByUnit(String unitId,Channel channel){
        ChannelGroup unitGroup = unitChannelGroupMapping.get(unitId);
        if (unitGroup == null) {
            unitGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
            unitChannelGroupMapping.put(unitId,unitGroup);
        }
        unitGroup.add(channel);
    }

    public static void removeChannelFromGroup(String unitId,Channel channel){
        ChannelGroup unitGroup = unitChannelGroupMapping.get(unitId);
        if (unitGroup != null) {
            unitGroup.remove(channel);
        }
    }

}
