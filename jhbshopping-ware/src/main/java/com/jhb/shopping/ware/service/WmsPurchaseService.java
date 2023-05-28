package com.jhb.shopping.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.ware.entity.WmsPurchaseEntity;

import java.util.Map;

/**
 * 采购信息
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:18:51
 */
public interface WmsPurchaseService extends IService<WmsPurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

