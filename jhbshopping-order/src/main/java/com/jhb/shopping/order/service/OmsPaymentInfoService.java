package com.jhb.shopping.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.order.entity.OmsPaymentInfoEntity;

import java.util.Map;

/**
 * 支付信息表
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:15:21
 */
public interface OmsPaymentInfoService extends IService<OmsPaymentInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

