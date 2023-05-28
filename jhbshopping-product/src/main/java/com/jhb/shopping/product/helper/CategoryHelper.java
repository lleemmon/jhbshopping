package com.jhb.shopping.product.helper;

import com.jhb.shopping.product.entity.CategoryEntity;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 57443
 */
public class CategoryHelper {
    public static List<CategoryEntity> getChildren(CategoryEntity rootEntity, List<CategoryEntity>allEntities){
        List<CategoryEntity> categoryEntities = allEntities.stream().filter(item -> rootEntity.getCatId().equals(item.getParentCid()))
                .map(item -> {
                    item.setChildren(getChildren(item, allEntities));
                    System.out.println(item);
                    return item;
                })
                .sorted((item1, item2) -> (item1.getSort() != null ? item1.getSort() : 0) - (item2.getSort() != null ? item2.getSort() : 0))
                .collect(Collectors.toList());
        return categoryEntities;
    }
}
