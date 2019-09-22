# sparrow
最小化业务逻辑，用来测试微服务各个组件

## 介绍
SpringCloud技术栈+docker容器化+k8s发布 练手项目
### 项目结构

## log


## SpringCloud采坑
### 版本对应关系
SpringCloud的大版本名称为伦敦地铁站名，按字母A-Z顺序
SpringCloud大版本与SpringBoot版本的对应关系
* Hoxton - 2.2.x
* Greenwich - 2.1.x
* Finchley - 2.0.x
* Edgware - 1.5.x
* Dalston - 1.5.x

### 版本命名问题
Spring新的的命名规则（boot和cloud）
2.0前后依赖包的名字会有改变比如

`spring-cloud-starter-eureka`=>`spring-cloud-starter-netflix-eureka-server`和`spring-cloud-starter-netflix-eureka-client`
因为有出现了Netflix的厂商（Alibaba）根据SpringCloud的微服务标准，所以会在依赖名称中添加厂商名称

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
eureka中默认配置，轮询更新服务列表的时间为30s
通过修改`registryFetchIntervalSeconds`配置来提高服务注册的感知速度
## 容器化采坑
### docker环境下的微服务间通信问题
本地可以用docker-compose的links