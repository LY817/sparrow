FROM java:openjdk-8-jre
LABEL author="luoyu817"
LABEL email="luoyu817@126.com"

ENV LANG C.UTF-8

ADD ./target/sparrow-ms-order-1.0-SNAPSHOT.jar /usr/local/app.jar
ADD ./docker-bootstrap.sh /usr/local/docker-bootstrap.sh

EXPOSE 10002

ENTRYPOINT [ "java","-jar","/usr/local/app.jar" ]
# SpringBoot外部配置
CMD ["--debug=true"]