-- user表添加用户类型字段 用来模拟分组的业务逻辑
ALTER TABLE `user`
ADD COLUMN `user_type`  varchar(50) NULL COMMENT '用户类型 S A B C ' AFTER `balance`;

-- username添加唯一索引
ALTER TABLE `user`
MODIFY COLUMN `user_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL AFTER `user_id`,
ADD UNIQUE INDEX `username_index` (`user_name`) USING BTREE COMMENT '用户名唯一索引';