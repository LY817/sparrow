WebSocket事件推送客户端

将服务端的事件（如mq订阅到的事件或接收到的http请求）透传给对应的WebSocket客户端

## WebSocket基础知识
HTTP是运行在TCP协议传输层上的应用协议，而WebSocket是通过HTTP协议协商如何连接，然后独立运行在TCP协议传输层上的应用协议

## 程序设计
### netty实现WebSocket服务端
1. 基本功能：mq生产者产生消息-推送服务消费到消息-将消息发送到连接的客户端
2. 添加业务约束：
3. 封装对象
### 在微服务的基础上 启一个netty服务 提供WebSocket服务
PushServer注入微服务调用实例


### 应用内部的事件
用事件来解耦 事件生成和WebSocket事件推送

自定义channel的概念，来区分不同业务场景的推送
```
mq消费消息产生事件 -> 包装成PushEvent -> 路由到不同的PushChannel
```

#### PushChannel 推送频道
对应不用的业务场景，作为netty-WebSocket和MQ消费者

一个场景对应一个Channel 会创建一个MQ的消费客户端 
订阅一个topic 通过对topic中tag过滤，来分发消息

##### 广播 不需要关注每个客户端的推送

- 通行记录
- 布控告警
##### 点对点推送
- 通知消息



#### PushEvent
