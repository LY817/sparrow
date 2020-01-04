#!/usr/bin/env bash

# 重新构建mysql数据库

# 新增迭代sql脚本自动构建步骤
# 1.dockerfile中环境变量以此添加
# - ENV FILE_x sparrow-update.sql
# - COPY ./$FILE_x $WORK_PATH/
# 2.mysql自动执行脚本sparrow-sql-bootstrap.sh中添加执行动作
# - source $WORK_PATH/$FILE_x;
docker build -t sparrow-mysql-auto:latest .

docker run --name mysql-sparrow -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -d sparrow-mysql-auto:latest