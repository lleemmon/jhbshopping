package com.jhb.shopping.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jhb.common.utils.PageUtils;
import com.jhb.common.utils.Query;

import com.jhb.shopping.coupon.dao.SmsSpuBoundsDao;
import com.jhb.shopping.coupon.entity.SmsSpuBoundsEntity;
import com.jhb.shopping.coupon.service.SmsSpuBoundsService;


@Service("smsSpuBoundsService")
public class SmsSpuBoundsServiceImpl extends ServiceImpl<SmsSpuBoundsDao, SmsSpuBoundsEntity> implements SmsSpuBoundsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsSpuBoundsEntity> page = this.page(
                new Query<SmsSpuBoundsEntity>().getPage(params),
                new QueryWrapper<SmsSpuBoundsEntity>()
        );

        return new PageUtils(page);
    }

}