package com.jhb.shopping.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.coupon.entity.SmsHomeAdvEntity;

import java.util.Map;

/**
 * 首页轮播广告
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:07:29
 */
public interface SmsHomeAdvService extends IService<SmsHomeAdvEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

