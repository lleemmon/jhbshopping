package com.jhb.shopping.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.member.entity.UmsGrowthChangeHistoryEntity;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:12:15
 */
public interface UmsGrowthChangeHistoryService extends IService<UmsGrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

