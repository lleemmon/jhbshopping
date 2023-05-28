package com.jhb.shopping.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.member.entity.UmsIntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:12:15
 */
public interface UmsIntegrationChangeHistoryService extends IService<UmsIntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

