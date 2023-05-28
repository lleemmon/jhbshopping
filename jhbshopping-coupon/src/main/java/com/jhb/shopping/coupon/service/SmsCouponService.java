package com.jhb.shopping.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.coupon.entity.SmsCouponEntity;

import java.util.Map;

/**
 * 优惠券信息
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:07:29
 */
public interface SmsCouponService extends IService<SmsCouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

