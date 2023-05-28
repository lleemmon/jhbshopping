package com.jhb.shopping.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.order.entity.OmsRefundInfoEntity;

import java.util.Map;

/**
 * 退款信息
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:15:21
 */
public interface OmsRefundInfoService extends IService<OmsRefundInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

