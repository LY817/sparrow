#!/bin/sh
# mvn打包
mvn clean install -Dmaven.test.skip=true
# todo 统一版本号
docker build -t sparrow-eureka-server:0.0.1 .