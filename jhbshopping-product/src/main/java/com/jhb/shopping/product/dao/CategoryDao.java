package com.jhb.shopping.product.dao;

import com.jhb.shopping.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 11:14:56
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
