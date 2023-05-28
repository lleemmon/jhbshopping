package com.jhb.shopping.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.coupon.entity.SmsMemberPriceEntity;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:07:29
 */
public interface SmsMemberPriceService extends IService<SmsMemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

