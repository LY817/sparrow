#!/bin/sh
# mvn打包
mvn clean install -Dmaven.test.skip=true
# todo 统一版本号
docker rmi -f sparrow-ms-inventory:latest
docker build -t sparrow-ms-inventory:latest .