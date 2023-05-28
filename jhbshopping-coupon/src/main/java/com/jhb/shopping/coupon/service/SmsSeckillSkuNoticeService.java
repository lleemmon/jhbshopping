package com.jhb.shopping.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.coupon.entity.SmsSeckillSkuNoticeEntity;

import java.util.Map;

/**
 * 秒杀商品通知订阅
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:07:30
 */
public interface SmsSeckillSkuNoticeService extends IService<SmsSeckillSkuNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

