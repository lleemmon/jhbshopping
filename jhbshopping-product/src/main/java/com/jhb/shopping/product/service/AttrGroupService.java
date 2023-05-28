package com.jhb.shopping.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 11:14:56
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

