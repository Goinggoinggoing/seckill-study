package com.example.seckilldemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckilldemo.entity.TGoods;
import com.example.seckilldemo.vo.GoodsVo;

import java.util.List;

/**
 * 商品表 服务类
 *
 * @author LiChao
 * @since 2022-03-03
 */
public interface ITGoodsService extends IService<TGoods> {

    /**
     * 返回商品列表
     *
     * @param
     * @return java.util.List<com.example.seckilldemo.vo.GoodsVo>
     * @author LC
     * @operation add
     * @date 5:49 下午 2022/3/3
     **/
    List<GoodsVo> findGoodsVo();

    /**
     * 获取商品详情
     *
     * @param goodsId
     * @return java.lang.String
     * @author LC
     * @operation add
     * @date 9:37 上午 2022/3/4
     **/
    GoodsVo findGoodsVobyGoodsId(Long goodsId);
}
