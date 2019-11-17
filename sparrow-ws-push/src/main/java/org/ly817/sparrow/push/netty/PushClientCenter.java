package org.ly817.sparrow.push.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

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
     * 根据不同的业务
     */
    public static Map<String,ChannelId> map = new ConcurrentHashMap<>();

    public static Map<String,ChannelId> map1 = new ConcurrentHashMap<>();

    public static boolean addClient(Channel clientChannel) {
        return globalChannels.add(clientChannel);
    }

    public static boolean removeClient(Channel clientChannel){
        return globalChannels.remove(clientChannel);
    }

}