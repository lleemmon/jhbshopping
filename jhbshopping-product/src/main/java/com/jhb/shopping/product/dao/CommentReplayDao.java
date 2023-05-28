package com.jhb.shopping.product.dao;

import com.jhb.shopping.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 11:14:56
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}
