#!/bin/sh
# mvn打包
mvn clean install -Dmaven.test.skip=true
# todo 统一版本号
docker rmi -f sparrow-zuul-gateway:latest
docker build -t sparrow-zuul-gateway:latest .