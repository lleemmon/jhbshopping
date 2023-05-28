package com.jhb.shopping.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.member.entity.UmsMemberLoginLogEntity;

import java.util.Map;

/**
 * 会员登录记录
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:12:15
 */
public interface UmsMemberLoginLogService extends IService<UmsMemberLoginLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

