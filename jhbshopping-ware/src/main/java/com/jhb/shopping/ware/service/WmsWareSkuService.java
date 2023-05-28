package com.jhb.shopping.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.ware.entity.WmsWareSkuEntity;

import java.util.Map;

/**
 * 商品库存
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:18:51
 */
public interface WmsWareSkuService extends IService<WmsWareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

