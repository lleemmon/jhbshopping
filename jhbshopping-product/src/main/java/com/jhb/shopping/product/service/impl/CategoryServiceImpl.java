package com.jhb.shopping.product.service.impl;

import com.jhb.shopping.product.dao.CategoryBrandRelationDao;
import com.jhb.shopping.product.entity.CategoryBrandRelationEntity;
import com.jhb.shopping.product.helper.CategoryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jhb.common.utils.PageUtils;
import com.jhb.common.utils.Query;

import com.jhb.shopping.product.dao.CategoryDao;
import com.jhb.shopping.product.entity.CategoryEntity;
import com.jhb.shopping.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryBrandRelationDao categoryBrandRelationDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
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
        Integer size = categoryBrandRelationDao.selectCount(new QueryWrapper<CategoryBrandRelationEntity>().in("catelog_id", asList));

        if (size == 0) {
            //逻辑删除
            baseMapper.deleteBatchIds(asList);
        } else {
            throw new RuntimeException("该菜单下面还有属性，无法删除!");
        }
    }

}