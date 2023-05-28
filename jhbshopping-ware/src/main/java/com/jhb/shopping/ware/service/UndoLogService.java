package com.jhb.shopping.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jhb.common.utils.PageUtils;
import com.jhb.shopping.ware.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:18:51
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

