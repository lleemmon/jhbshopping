package com.jhb.shopping.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.order.entity.OmsOrderSettingEntity;

import java.util.Map;

/**
 * 订单配置信息
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:15:21
 */
public interface OmsOrderSettingService extends IService<OmsOrderSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

