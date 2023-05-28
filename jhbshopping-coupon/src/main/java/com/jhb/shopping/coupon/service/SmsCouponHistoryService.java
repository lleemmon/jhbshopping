package com.jhb.shopping.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.coupon.entity.SmsCouponHistoryEntity;

import java.util.Map;

/**
 * 优惠券领取历史记录
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:07:29
 */
public interface SmsCouponHistoryService extends IService<SmsCouponHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

