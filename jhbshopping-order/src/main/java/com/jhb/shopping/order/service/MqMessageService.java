package com.jhb.shopping.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.order.entity.MqMessageEntity;

import java.util.Map;

/**
 * 
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:15:21
 */
public interface MqMessageService extends IService<MqMessageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

