package com.example.seckilldemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *
 * @author LiChao
 * @since 2022-03-03
 */
@TableName("t_order")
@ApiModel(value = "", description = "")
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 订单ID **/
    @ApiModelProperty("订单ID")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 用户ID **/
    @ApiModelProperty("用户ID")
    private Long userId;

    /** 商品ID **/
    @ApiModelProperty("商品ID")
    private Long goodsId;

    /** 收获地址ID **/
    @ApiModelProperty("收获地址ID")
    private Long deliveryAddrId;

    /** 商品名字 **/
    @ApiModelProperty("商品名字")
    private String goodsName;

    /** 商品数量 **/
    @ApiModelProperty("商品数量")
    private Integer goodsCount;

    /** 商品价格 **/
    @ApiModelProperty("商品价格")
    private BigDecimal goodsPrice;

    /** 1 pc,2 android, 3 ios **/
    @ApiModelProperty("1 pc,2 android, 3 ios")
    private Integer orderChannel;

    /** 订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退货，5已完成 **/
    @ApiModelProperty("订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退货，5已完成")
    private Integer status;

    /** 订单创建时间 **/
    @ApiModelProperty("订单创建时间")
    private Date createDate;

    /** 支付时间 **/
    @ApiModelProperty("支付时间")
    private Date payDate;


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

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getDeliveryAddrId() {
        return deliveryAddrId;
    }

    public void setDeliveryAddrId(Long deliveryAddrId) {
        this.deliveryAddrId = deliveryAddrId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(Integer orderChannel) {
        this.orderChannel = orderChannel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return "TOrder{" +
        "id=" + id +
        ", userId=" + userId +
        ", goodsId=" + goodsId +
        ", deliveryAddrId=" + deliveryAddrId +
        ", goodsName=" + goodsName +
        ", goodsCount=" + goodsCount +
        ", goodsPrice=" + goodsPrice +
        ", orderChannel=" + orderChannel +
        ", status=" + status +
        ", createDate=" + createDate +
        ", payDate=" + payDate +
        "}";
    }
}
