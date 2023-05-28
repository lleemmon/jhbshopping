package com.jhb.shopping.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.coupon.entity.SmsHomeSubjectEntity;

import java.util.Map;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:07:29
 */
public interface SmsHomeSubjectService extends IService<SmsHomeSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

