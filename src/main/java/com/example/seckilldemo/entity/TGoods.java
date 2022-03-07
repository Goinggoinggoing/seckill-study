package com.example.seckilldemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品表
 *
 * @author LiChao
 * @since 2022-03-03
 */
@TableName("t_goods")
@ApiModel(value = "商品表", description = "商品表")
public class TGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 商品ID **/
    @ApiModelProperty("商品ID")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 商品名称 **/
    @ApiModelProperty("商品名称")
    private String goodsName;

    /** 商品标题 **/
    @ApiModelProperty("商品标题")
    private String goodsTitle;

    /** 商品图片 **/
    @ApiModelProperty("商品图片")
    private String goodsImg;

    /** 商品详情 **/
    @ApiModelProperty("商品详情")
    private String goodsDetail;

    /** 商品价格 **/
    @ApiModelProperty("商品价格")
    private BigDecimal goodsPrice;

    /** 商品库存，-1表示没有限制 **/
    @ApiModelProperty("商品库存，-1表示没有限制")
    private Integer goodsStock;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    @Override
    public String toString() {
        return "TGoods{" +
        "id=" + id +
        ", goodsName=" + goodsName +
        ", goodsTitle=" + goodsTitle +
        ", goodsImg=" + goodsImg +
        ", goodsDetail=" + goodsDetail +
        ", goodsPrice=" + goodsPrice +
        ", goodsStock=" + goodsStock +
        "}";
    }
}
