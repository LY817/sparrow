# sparrow
最小化业务逻辑，用来测试微服务各个组件

## 介绍
SpringCloud技术栈+docker容器化+k8s发布 练手项目
## 项目结构

### api
定义微服务之间的接口和相关实体类

#### 服务接口

feign（服务消费者）+SpringMVC（服务调用者）实现共同的服务接口 作为服务协议

实现伪RPC

公共的服务协议接口 方法上使用XXXMapping标注，分别被SpringMVC的Controller和feign客户端实现

> **注意**不要在公共的服务协议接口的类上标注RequestMapping，可能会导致Ambiguous mapping

#### 实体类

- dto
- 数据库实体类 

### global-starter
统一公共功能的配置 

被所有微服务引用

#### feign自定义异常解析

#### 雪花算法id生成器

全局的id序列号生成器

#### mq同步协议

将通用的业务模块作为starter


### Zuul网关
#### 动态服务映射



#### 通用身份验证逻辑



#### 灰度发布



### admin
#### 用户权限验证服务



#### 服务映射管理





---


## SpringCloud
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


## 容器化
### 调试容器方式 exec -it

### dockerfile中RUN/ENTRYPOINT/CMD的区别与实践

#### RUN
RUN命令每执行一次都会创建新的一层镜像
主要用来构建执行环节、安装先关依赖
为了避免构建多个镜像，尽量将多个RUN命令写在一起，通过 \ 隔开
#### ENTRYPOINT
ENTRYPOINT配置容器启动时的执行命令，通常用来启动应用程序
可以是一个shell脚本（方便在执行前添加其他逻辑）
也可以在sh脚本中通过$0、$1获取cmd外部输入的命令
下列为redis进行的docker-entrypoint.sh
```bash
# first arg is `-f` or `--some-option`
# or first arg is `something.conf`
if [ "${1#-}" != "$1" ] || [ "${1%.conf}" != "$1" ]; then
        set -- redis-server "$@"
fi

# allow the container to be started with `--user`
if [ "$1" = 'redis-server' -a "$(id -u)" = '0' ]; then
        find . \! -user redis -exec chown redis '{}' +
        exec gosu redis "$0" "$@"
fi

exec "$@"
```
也可以是一个exec格式的命令（方便接收应用程序（SpringBoot）接收外层（docker命令行或者docker-compose）通过cmd输入的动态参数）

#### CMD
设置容器的默认执行的命令，在entrypoint之后执行
如果exec式的CMD命令中，缺省了可执行命令，则会让ENTRYPOINT的可执行命令来接收这些参数（SpringBoot应用可以用过这个方式来从外层修改配置而不用重新制作镜像）

### docker环境下的微服务间通信问题
本地可以用docker-compose的links