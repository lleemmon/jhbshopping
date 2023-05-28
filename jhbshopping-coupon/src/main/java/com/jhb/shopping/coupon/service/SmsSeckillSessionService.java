package com.jhb.shopping.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.coupon.entity.SmsSeckillSessionEntity;

import java.util.Map;

/**
 * 秒杀活动场次
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:07:30
 */
public interface SmsSeckillSessionService extends IService<SmsSeckillSessionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

