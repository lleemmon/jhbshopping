package com.jhb.shopping.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.jhb.shopping.product.entity.AttrEntity;
import com.jhb.shopping.product.service.AttrService;
import com.jhb.shopping.product.service.CategoryService;
import com.jhb.shopping.product.vo.AttrGroupRelationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jhb.shopping.product.entity.AttrGroupEntity;
import com.jhb.shopping.product.service.AttrGroupService;
import com.jhb.common.utils.PageUtils;
import com.jhb.common.utils.R;



/**
 * 属性分组
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 13:37:18
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrService attrService;
    /**
     * 列表
     */
    @RequestMapping("/list/{catelogId}")
    //@RequiresPermissions("product:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params, @PathVariable("catelogId") Long catelogId){

        PageUtils page = attrGroupService.queryPage(params, catelogId);

        return R.ok().put("page", page);
    }

    @RequestMapping("/{attrgroupId}/attr/relation")
    //@RequiresPermissions("product:attrgroup:list")
    public R getAttrByAttrGroupId(@PathVariable("attrgroupId") Long attrgroupId){

        List<AttrEntity> attrEntities =  attrService.getRelationAttr(attrgroupId);

        return R.ok().put("data", attrEntities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    //@RequiresPermissions("product:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long catelogId = attrGroup.getCatelogId();
        List<Long> catelogPath = categoryService.findCatelogPath(catelogId);
        attrGroup.setCatelogPath(catelogPath);
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

    @PostMapping ("/attr/relation/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public R deleteRelation(@RequestBody List<AttrGroupRelationVo> attrGroupRelationVo){
        attrService.deleteRelation(attrGroupRelationVo);
        return R.ok();
    }
}
