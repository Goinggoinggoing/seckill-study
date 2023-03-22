# seckill-study
笔记：https://goinggoinggoing.github.io/2023/03/20/B站秒杀项目

项目来源：https://gitee.com/guizhizhe/seckill_demo ，原项目代码为最终结果，对前期一步步学习可能存在麻烦，因此本项目添加了一些中间过程接口，可以先看原项目的文档说明，在README-default.md也拷贝了一份

视频：https://www.bilibili.com/video/BV1sf4y1L7KE





### 接口说明

SekillController: 三个阶段

- doSeckill1:  对应到 **P43**，         update排他+唯一索引实现秒杀(没有做order页面静态化)
- doSeckill2：对应到 **P53**，         order界面静态化 +  redis预减库存 + 内存标记 + MQ
- doSeckill ：最终秒杀方案          一些安全上的优化

对应到发起请求界面static\goodsDetail.html 52~67行



### 页面说明

前后端结合项目，两种处理页面方式，二者对比可以看 static和templates下的orderDetail 页面

1. 前端页面在template下，通过controller返回访问，并`model.add添加数据`。`h:text="${goods.goodsName}"`区数据， 不可直接访问
2. 在static下的页面可直接访问，并在页面加载时ajax请求返回json数据，`$("#goodsName").text(goods.goodsName);`根据id注入数据。（相当于前后端分离）

在项目初始化搭建过程中，都是方法1，但到P39开始做页面静态化orderDetail 转到方法2，代码中直接是方法2



### 环境搭建

需要安装配置Mysql、Redis、RabbitMQ

**Redis**：本地安装，或者远程linux服务器直接docker装，不装项目起不来。

**RabbitMQ**：推荐RabbitMQ直接docker安装，两行直接搞定，不行再看看防火墙、安全组。（不安装也能学到P44）

```bash
docker pull rabbitmq

docker run \
 -e RABBITMQ_DEFAULT_USER=guest \
 -e RABBITMQ_DEFAULT_PASS=guest \
 --name mq \
 --hostname mq1 \
 -p 15672:15672 \
 -p 5672:5672 \
 -d \
 rabbitmq:3-management
```



### 注意事项

1.在该项目中核心就是秒杀的实现：不能超卖、不能重复抢

- 不能超卖在doSeckill2中通过update的排他性实现。而在doSeckill3中通过redis预减库存(redis的原子性实现)
- 不能重复抢通过唯一索引实现，默认建表时没有添加，压测可以把用户加少点商品多一点就可以复现重复购买

2.优化不过就是把数据库的重复访问，能放到redis就放到redis；而如果访问redis太多了就再加一层内存标记

3.redis和mysql要么都在远程，要么都在本地，否则可能会出现redis缓存优化了但QPS没提升



