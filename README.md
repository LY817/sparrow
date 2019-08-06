# sparrow
最小化业务逻辑，用来测试微服务各个组件

## 介绍
SpringCloud技术栈+docker容器化+k8s发布 练手项目
### 项目结构

## SpringCloud采坑
### SpringCloud版本问题
Spring新的的命名规则（boot和cloud）
2.0前后依赖包的名字会有改变比如

`spring-cloud-starter-eureka`=>`spring-cloud-starter-netflix-eureka-server`和`spring-cloud-starter-netflix-eureka-client`

####依赖包的命名规范
官方提供的starter 
```
spring-boot-starter-xxxx
spring-cloud-starter-{子项目名称}-xxxx
```
非官方出的starter
```
xxxx-spring-boot-starter
```
### eureka注册中心 服务发现延时高

## 容器化采坑
### docker环境下的微服务间通信问题