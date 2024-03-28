CREATE DATABASE seckill
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

use seckill;
DROP TABLE IF EXISTS t_user;
DROP TABLE IF EXISTS t_goods;
DROP TABLE IF EXISTS t_order;
DROP TABLE IF EXISTS t_seckill_goods;
DROP TABLE IF EXISTS t_seckill_order;


CREATE TABLE t_user(
                       `id` BIGINT(20) NOT NULL COMMENT '用户ID,手机号码',
                       `nickname` VARCHAR(255) not NULL,
                       `password` VARCHAR(32) DEFAULT NULL COMMENT 'MD5(MD5(pass明文+固定salt)+salt)',
                       `salt` VARCHAR(10) DEFAULT NULL,
                       `head` VARCHAR(128) DEFAULT NULL COMMENT '头像',
                       `register_date` datetime DEFAULT NULL COMMENT '注册时间',
                       `last_login_date` datetime DEFAULT NULL COMMENT '最后一次登录事件',
                       `login_count` int(11) DEFAULT '0' COMMENT '登录次数',
                       PRIMARY KEY(`id`)
)
    COMMENT '用户表';
-- ----------------------------------------------
CREATE TABLE t_goods(
                        id BIGINT(20) not NULL AuTO_increment COMMENT '商品ID',
                        goods_name VARCHAR(16) DEFAULT NULL COMMENT '商品名称',
                        goods_title VARCHAR(64) DEFAULT NULL COMMENT '商品标题',
                        goods_img VARCHAR(64) DEFAULT NULL COMMENT '商品图片',
                        goods_detail LONGTEXT COMMENT '商品详情',
                        goods_price DECIMAL(10,2) DEFAULT '0.00' COMMENT '商品价格',
                        goods_stock INT(11) DEFAULT '0' COMMENT '商品库存，-1表示没有限制',
                        PRIMARY KEY(id)
)
    COMMENT '商品表';
-- ----------------------------------------------
CREATE TABLE `t_order` (
                           `id` BIGINT(20) NOT NULL  AUTO_INCREMENT COMMENT '订单ID',
                           `user_id` BIGINT(20) DEFAULT NULL COMMENT '用户ID',
                           `goods_id` BIGINT(20) DEFAULT NULL COMMENT '商品ID',
                           `delivery_addr_id` BIGINT(20) DEFAULT NULL  COMMENT '收获地址ID',
                           `goods_name` VARCHAR(16) DEFAULT NULL  COMMENT '商品名字',
                           `goods_count` INT(20) DEFAULT '0'  COMMENT '商品数量',
                           `goods_price` DECIMAL(10,2) DEFAULT '0.00'  COMMENT '商品价格',
                           `order_channel` TINYINT(4) DEFAULT '0'  COMMENT '1 pc,2 android, 3 ios',
                           `status` TINYINT(4) DEFAULT '0'  COMMENT '订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退货，5已完成',
                           `create_date` datetime DEFAULT NULL  COMMENT '订单创建时间',
                           `pay_date` datetime DEFAULT NULL  COMMENT '支付时间',
                           PRIMARY KEY(`id`)
)ENGINE = INNODB AUTO_INCREMENT=12 DEFAULT CHARSET = utf8mb4
COMMENT '订单表';

-- ----------------------------------------------
CREATE TABLE `t_seckill_goods`(
                                  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '秒杀商品ID',
                                  `goods_id` BIGINT(20) NOT NULL COMMENT '商品ID',
                                  `seckill_price` DECIMAL(10,2) NOT NULL COMMENT '秒杀价',
                                  `stock_count` INT(10) NOT NULL  COMMENT '库存数量',
                                  `start_date` datetime NOT NULL  COMMENT '秒杀开始时间',
                                  `end_date` datetime NOT NULL COMMENT '秒杀结束时间',
                                  PRIMARY KEY(`id`)
)ENGINE = INNODB AUTO_INCREMENT=3 DEFAULT CHARSET = utf8mb4
COMMENT '秒杀商品表'
;
-- ----------------------------------------------
CREATE TABLE `t_seckill_order` (
                                   `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '秒杀订单ID',
                                   `user_id` BIGINT(20) NOT NULL  COMMENT '用户ID',
                                   `order_id` BIGINT(20) NOT NULL  COMMENT '订单ID',
                                   `goods_id` BIGINT(20) NOT NULL  COMMENT '商品ID',
                                   PRIMARY KEY(`id`)
)ENGINE = INNODB AUTO_INCREMENT=3 DEFAULT CHARSET = utf8mb4
COMMENT '秒杀订单表'
;

INSERT INTO t_user (id, nickname, password, salt) VALUES (1000, 'user0', '6e0a7fe692684372437c9e508508990d', '1a2b3c');
INSERT INTO `t_goods` values(1,'iphone12', 'iphone12 64GB', '/img/iphone12.png', 'Iphone 12 64', '6299.00', 100),(2,'iphone12 pro', 'iphone12 pro 64GB', '/img/iphone12pro.png', 'Iphone 12 pro 64', '9299.00', 100);
INSERT INTO `t_seckill_goods` values(1, 1, '629', 10, '2020-11-01 08:00:00', '2020-11-01 09:00:00'),(2, 2, '929', 10, '2020-11-01 08:00:00', '2020-11-01 09:00:00');



-- ----------------------------------------------
-- 添加索引，讲到时在加
ALTER TABLE `seckill`.`t_seckill_order`
    ADD UNIQUE INDEX `seckill_uid_gid`(user_id, goods_id) USING BTREE COMMENT '用户ID+商品ID成为唯一索引，';
-- ----------------------------------------------
