package com.jhb.shopping.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jhb.common.constant.ProductConstant;
import com.jhb.common.utils.Constant;
import com.jhb.shopping.product.dao.AttrAttrgroupRelationDao;
import com.jhb.shopping.product.dao.AttrGroupDao;
import com.jhb.shopping.product.dao.CategoryDao;
import com.jhb.shopping.product.entity.AttrAttrgroupRelationEntity;
import com.jhb.shopping.product.entity.AttrGroupEntity;
import com.jhb.shopping.product.entity.CategoryEntity;
import com.jhb.shopping.product.service.CategoryService;
import com.jhb.shopping.product.vo.AttrGroupRelationVo;
import com.jhb.shopping.product.vo.AttrRespVo;
import com.jhb.shopping.product.vo.AttrVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jhb.common.utils.PageUtils;
import com.jhb.common.utils.Query;

import com.jhb.shopping.product.dao.AttrDao;
import com.jhb.shopping.product.entity.AttrEntity;
import com.jhb.shopping.product.service.AttrService;
import org.springframework.transaction.annotation.Transactional;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {
    @Autowired
    private AttrAttrgroupRelationDao relationDao;

    @Autowired
    private AttrGroupDao attrGroupDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrDao attrDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void saveAttr(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr, attrEntity);
        save(attrEntity);
        if(attr.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()){
            AttrAttrgroupRelationEntity entity = new AttrAttrgroupRelationEntity();
            entity.setAttrId(attrEntity.getAttrId());
            entity.setAttrGroupId(attr.getAttrGroupId());
            //保存关联关系
            relationDao.insert(entity);
        }
    }

    @Override
    public PageUtils queryBaseAttrPage(Map<String, Object> params, Long cateLogId, String attrType) {
        LambdaQueryWrapper<AttrEntity>wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AttrEntity::getAttrType, "base".equalsIgnoreCase(attrType)?
                ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode():
                ProductConstant.AttrEnum.ATTR_TYPE_SALE.getCode());
        if(cateLogId != 0){
            wrapper.eq(AttrEntity::getCatelogId, cateLogId);
        }
        String key = (String) params.get("key");
        if(StringUtils.isNotEmpty(key)){
            wrapper.and((obj) -> {
                obj.eq(AttrEntity::getAttrId, key).or().like(AttrEntity::getAttrName, key);
            });
        }
        IPage<AttrEntity> page = this.page(
            new Query<AttrEntity>().getPage(params), wrapper
        );
        List<AttrEntity> records = page.getRecords();
        PageUtils pageUtils = new PageUtils(page);
        List<AttrRespVo> collect = records.stream().map(attrEntity -> {
            AttrRespVo attrRespVo = new AttrRespVo();
            BeanUtils.copyProperties(attrEntity, attrRespVo);
            AttrAttrgroupRelationEntity entity = relationDao.selectOne(new LambdaQueryWrapper<AttrAttrgroupRelationEntity>()
                    .eq(AttrAttrgroupRelationEntity::getAttrId, attrEntity.getAttrId()));
            if("base".equalsIgnoreCase(attrType)) {
                if (entity != null) {
                    AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(entity.getAttrGroupId());
                    attrRespVo.setGroupName(attrGroupEntity.getAttrGroupName());
                }
            }
            CategoryEntity categoryEntity = categoryDao.selectById(attrEntity.getCatelogId());
            if (categoryEntity != null) {
                attrRespVo.setCatelogName(categoryEntity.getName());
            }
            return attrRespVo;
        }).collect(Collectors.toList());
        pageUtils.setList(collect);
        return pageUtils;
    }

    @Override
    public AttrRespVo getDetail(Long attrId) {
        AttrRespVo attrRespVo = new AttrRespVo();
        AttrEntity attrEntity = baseMapper.selectById(attrId);
        BeanUtils.copyProperties(attrEntity, attrRespVo);
        Long catelogId = attrEntity.getCatelogId();
        List<Long> catalogPath = categoryService.findCatelogPath(catelogId);
        attrRespVo.setCatelogPath(catalogPath);

        if(attrEntity.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()) {
            AttrAttrgroupRelationEntity entity = relationDao.selectOne(new LambdaQueryWrapper<AttrAttrgroupRelationEntity>()
                    .eq(AttrAttrgroupRelationEntity::getAttrId, attrEntity.getAttrId()));
            if (entity != null) {
                attrRespVo.setAttrGroupId(entity.getAttrGroupId());
                AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(entity.getAttrGroupId());
                if (attrGroupEntity != null) {
                    attrRespVo.setGroupName(attrGroupEntity.getAttrGroupName());
                }
            }
        }

        CategoryEntity categoryEntity = categoryDao.selectById(catelogId);
        if(categoryEntity != null){
            attrRespVo.setCatelogName(categoryEntity.getName());
        }
        return attrRespVo;
    }

    @Transactional
    @Override
    public void updateAttr(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr, attrEntity);
        this.updateById(attrEntity);
        if(attrEntity.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()) {
            //修改分组关联
            AttrAttrgroupRelationEntity entity = new AttrAttrgroupRelationEntity();
            entity.setAttrId(attr.getAttrId());
            entity.setAttrGroupId(attr.getAttrGroupId());
            Integer count = relationDao.selectCount(new LambdaQueryWrapper<AttrAttrgroupRelationEntity>().eq(AttrAttrgroupRelationEntity::getAttrId, attr.getAttrId()));
            if (count > 0) {
                relationDao.update(entity,
                        new LambdaQueryWrapper<AttrAttrgroupRelationEntity>().eq(AttrAttrgroupRelationEntity::getAttrId, entity.getAttrId()));
            } else {
                relationDao.insert(entity);
            }
        }
    }

    @Override
    public List<AttrEntity> getRelationAttr(Long attrgroupId) {
        LambdaQueryWrapper<AttrAttrgroupRelationEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AttrAttrgroupRelationEntity::getAttrGroupId, attrgroupId);
        List<Long> collect = relationDao.selectList(wrapper).stream().map(item -> item.getAttrId()).collect(Collectors.toList());
        LambdaQueryWrapper<AttrEntity>wrapper2 = new LambdaQueryWrapper<>();
        wrapper2.in(AttrEntity::getAttrId, collect);
        return attrDao.selectList(wrapper2);
    }

    @Override
    public void deleteRelation(List<AttrGroupRelationVo> attrGroupRelationVo) {
        List<AttrAttrgroupRelationEntity> collect = attrGroupRelationVo.stream().map(item -> {
            AttrAttrgroupRelationEntity entity = new AttrAttrgroupRelationEntity();
            BeanUtils.copyProperties(item, entity);
            return entity;
        }).collect(Collectors.toList());
        relationDao.deleteBatchRelation(collect);
    }

}
