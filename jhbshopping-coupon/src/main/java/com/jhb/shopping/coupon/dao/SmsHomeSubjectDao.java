package com.jhb.shopping.coupon.dao;

import com.jhb.shopping.coupon.entity.SmsHomeSubjectEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 * 
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:07:29
 */
@Mapper
public interface SmsHomeSubjectDao extends BaseMapper<SmsHomeSubjectEntity> {
	
}
