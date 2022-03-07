package com.example.seckilldemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 秒杀订单表
 *
 * @author LiChao
 * @since 2022-03-03
 */
@TableName("t_seckill_order")
@ApiModel(value = "秒杀订单表", description = "秒杀订单表")
public class TSeckillOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 秒杀订单ID **/
    @ApiModelProperty("秒杀订单ID")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 用户ID **/
    @ApiModelProperty("用户ID")
    private Long userId;

    /** 订单ID **/
    @ApiModelProperty("订单ID")
    private Long orderId;

    /** 商品ID **/
    @ApiModelProperty("商品ID")
    private Long goodsId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "TSeckillOrder{" +
        "id=" + id +
        ", userId=" + userId +
        ", orderId=" + orderId +
        ", goodsId=" + goodsId +
        "}";
    }
}
