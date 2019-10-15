FROM java:openjdk-8-jre
LABEL author="luoyu817"
LABEL email="luoyu817@126.com"

ENV LANG C.UTF-8

ADD ./target/sparrow-ms-admin-1.0-SNAPSHOT.jar /usr/local/app.jar
ADD ./docker-bootstrap.sh /usr/local/docker-bootstrap.sh

EXPOSE 10001

# 使用shell作为ENTRYPOINT 可以设置环境变量，但是不方便接受外层的命令行传入的配置
# 需要在sh脚本中获取参数作为变量
# ENTRYPOINT [ "sh","/usr/local/docker-bootstrap.sh" ]

# 使用命令行作为ENTRYPOINT 可以接受外层的命令行参数
ENTRYPOINT [ "java","-jar","/usr/local/app.jar" ]
# SpringBoot外部配置
# CMD或者run的命令 会接在ENTRYPOINT命令的后面
CMD ["--debug=true"]