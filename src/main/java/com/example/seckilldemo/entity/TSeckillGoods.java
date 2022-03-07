package com.example.seckilldemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 秒杀商品表
 *
 * @author LiChao
 * @since 2022-03-03
 */
@TableName("t_seckill_goods")
@ApiModel(value = "秒杀商品表", description = "秒杀商品表")
public class TSeckillGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 秒杀商品ID **/
    @ApiModelProperty("秒杀商品ID")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 商品ID **/
    @ApiModelProperty("商品ID")
    private Long goodsId;

    /** 秒杀家 **/
    @ApiModelProperty("秒杀家")
    private BigDecimal seckillPrice;

    /** 库存数量 **/
    @ApiModelProperty("库存数量")
    private Integer stockCount;

    /** 秒杀开始时间 **/
    @ApiModelProperty("秒杀开始时间")
    private LocalDateTime startDate;

    /** 秒杀结束时间 **/
    @ApiModelProperty("秒杀结束时间")
    private LocalDateTime endDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(BigDecimal seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "TSeckillGoods{" +
        "id=" + id +
        ", goodsId=" + goodsId +
        ", seckillPrice=" + seckillPrice +
        ", stockCount=" + stockCount +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        "}";
    }
}
