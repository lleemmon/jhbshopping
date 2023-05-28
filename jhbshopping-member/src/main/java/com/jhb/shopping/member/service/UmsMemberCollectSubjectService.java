package com.jhb.shopping.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.member.entity.UmsMemberCollectSubjectEntity;

import java.util.Map;

/**
 * 会员收藏的专题活动
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:12:15
 */
public interface UmsMemberCollectSubjectService extends IService<UmsMemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

