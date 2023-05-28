package com.jhb.shopping.coupon.dao;

import com.jhb.shopping.coupon.entity.SmsCouponSpuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 * 
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:07:29
 */
@Mapper
public interface SmsCouponSpuRelationDao extends BaseMapper<SmsCouponSpuRelationEntity> {
	
}
