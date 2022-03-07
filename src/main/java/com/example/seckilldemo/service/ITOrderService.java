package com.example.seckilldemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckilldemo.entity.TOrder;
import com.example.seckilldemo.entity.TUser;
import com.example.seckilldemo.vo.GoodsVo;
import com.example.seckilldemo.vo.OrderDeatilVo;

/**
 *  服务类
 *
 * @author LiChao
 * @since 2022-03-03
 */
public interface ITOrderService extends IService<TOrder> {

    /**
     * 秒杀
     * @author LC
     * @operation add
     * @date 1:44 下午 2022/3/4
     * @param user 用户对象
     * @param goodsVo 商品对象
     * @return com.example.seckilldemo.entity.TOrder
     **/
    TOrder secKill(TUser user, GoodsVo goodsVo);

    /**
     * 订单详情方法
     * @author LC
     * @operation add
     * @date 10:21 下午 2022/3/6
     * @param orderId
     * @return com.example.seckilldemo.vo.OrderDeatilVo
     **/
    OrderDeatilVo detail(Long orderId);
}
