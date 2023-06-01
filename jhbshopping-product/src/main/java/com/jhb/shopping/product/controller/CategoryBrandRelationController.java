package com.jhb.shopping.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jhb.shopping.product.entity.CategoryBrandRelationEntity;
import com.jhb.shopping.product.service.CategoryBrandRelationService;
import com.jhb.common.utils.PageUtils;
import com.jhb.common.utils.R;



/**
 * 品牌分类关联
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 13:37:18
 */
@RestController
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:categorybrandrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryBrandRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    @GetMapping("/catelog/list")
    //@RequiresPermissions("product:categorybrandrelation:info")
    public R catelogList(@RequestParam("brandId") Long brandId){
        LambdaQueryWrapper<CategoryBrandRelationEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CategoryBrandRelationEntity::getBrandId, brandId);
        List<CategoryBrandRelationEntity> entities = categoryBrandRelationService.list(wrapper);
        return R.ok().put("data", entities);
    }
    /**
     * 信息
     */
//    @RequestMapping("/brands/list")
//    //@RequiresPermissions("product:categorybrandrelation:info")
//    public R info(@PathVariable("id") Long id){
//        CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);
//
//        return R.ok().put("categoryBrandRelation", categoryBrandRelation);
//    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:categorybrandrelation:info")
    public R info(@PathVariable("id") Long id){
		CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);

        return R.ok().put("categoryBrandRelation", categoryBrandRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:categorybrandrelation:save")
    public R save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
        categoryBrandRelationService.saveDetail(categoryBrandRelation);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:categorybrandrelation:update")
    public R update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
		categoryBrandRelationService.updateById(categoryBrandRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:categorybrandrelation:delete")
    public R delete(@RequestBody Long[] ids){
		categoryBrandRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
