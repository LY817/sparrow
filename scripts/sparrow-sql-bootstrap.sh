#!/usr/bin/env bash
mysql -uroot -p$MYSQL_ROOT_PASSWORD <<EOF
source $WORK_PATH/$FILE_0;
source $WORK_PATH/$FILE_1;
source $WORK_PATH/$FILE_3;
source $WORK_PATH/$FILE_3;