package com.jhb.shopping.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jhb.shopping.product.dao.CategoryBrandRelationDao;
import com.jhb.shopping.product.entity.CategoryBrandRelationEntity;
import com.jhb.shopping.product.helper.CategoryHelper;
import com.jhb.shopping.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jhb.common.utils.PageUtils;
import com.jhb.common.utils.Query;

import com.jhb.shopping.product.dao.CategoryDao;
import com.jhb.shopping.product.entity.CategoryEntity;
import com.jhb.shopping.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryEntities = baseMapper.selectList(new QueryWrapper<>());
        List<CategoryEntity> categoryEntitiesTree = categoryEntities.stream().filter(item -> item.getParentCid() == 0)
                .map(item -> {
                    item.setChildren(CategoryHelper.getChildren(item, categoryEntities));
                    return item;
                })
                .sorted((item1, item2) -> (item1.getSort() != null ? item1.getSort() : 0) - (item2.getSort() != null ? item2.getSort() : 0))
                .collect(Collectors.toList());
        return categoryEntitiesTree;
    }

    @Override
    public void removeCategoryByIds(List<Long> asList) {
        Integer size = baseMapper.selectCount(new LambdaQueryWrapper<CategoryEntity>().in(CategoryEntity::getCatId, asList));
        if (size == 0) {
            //逻辑删除
            baseMapper.deleteBatchIds(asList);
        } else {
            throw new RuntimeException("该菜单下面还有属性，无法删除!");
        }
    }

    @Override
    public List<Long> findCatelogPath(Long catelogId) {
        List<Long> catalogPath = new ArrayList<>();
        catalogPath.add(catelogId);
        LambdaQueryWrapper<CategoryEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CategoryEntity::getCatId, catelogId);
        CategoryEntity node = baseMapper.selectOne(wrapper);
        while (catalogPath.size() < 3) {
            if(node == null){
                throw new RuntimeException("节点丢失！");
            }
            Long parentCid = node.getParentCid();
            wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(CategoryEntity::getCatId, parentCid);
            node = baseMapper.selectOne(wrapper);
            catalogPath.add(parentCid);
        }
        Collections.reverse(catalogPath);
        return catalogPath;
    }

    @Transactional
    @Override
    public void updateCascade(CategoryEntity category) {
        baseMapper.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());
        //TODO 更新其它关联关系
    }

}
