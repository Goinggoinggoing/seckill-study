-- 删除订单表
DELETE FROM t_order;
DELETE FROM t_seckill_order;

-- 回复订单商品表
UPDATE t_seckill_goods SET stock_count=10;


SELECT * FROM t_seckill_order;

SELECT * FROM t_order;

SELECT * FROM t_seckill_goods;