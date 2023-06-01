package com.jhb.shopping.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jhb.common.utils.PageUtils;
import com.jhb.common.utils.Query;

import com.jhb.shopping.product.dao.AttrGroupDao;
import com.jhb.shopping.product.entity.AttrGroupEntity;
import com.jhb.shopping.product.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        // 规定 catelogId = 0 查询所有
        LambdaQueryWrapper<AttrGroupEntity> wrapper = new LambdaQueryWrapper<>();
        if(catelogId != 0){
            wrapper.eq(AttrGroupEntity::getCatelogId, catelogId);
        }
        String key = (String) params.get("key");
        if(StringUtils.isNotEmpty(key)){
            wrapper.and((obj)->{
                obj.eq(AttrGroupEntity::getAttrGroupId, key).or()
                        .like(AttrGroupEntity::getAttrGroupName, key);
            });
        }
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params), wrapper
        );
        return new PageUtils(page);
    }

}
