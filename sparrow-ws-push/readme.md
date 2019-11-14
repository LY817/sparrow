WebSocket事件推送客户端

将服务端的事件（如mq订阅到的事件或接收到的http请求）透传给对应的WebSocket客户端

## WebSocket基础知识
HTTP是运行在TCP协议传输层上的应用协议，而WebSocket是通过HTTP协议协商如何连接，然后独立运行在TCP协议传输层上的应用协议

## 程序设计
### netty实现WebSocket服务端

### 应用内部的事件
用事件来解耦 事件生成和WebSocket事件推送

自定义channel的概念，来区分不同业务场景的推送
