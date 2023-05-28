package com.jhb.shopping.member.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.jhb.shopping.member.feign.CouponFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhb.shopping.member.entity.UmsMemberEntity;
import com.jhb.shopping.member.service.UmsMemberService;
import com.jhb.common.utils.PageUtils;
import com.jhb.common.utils.R;



/**
 * 会员
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:12:15
 */
@RestController
@RequestMapping("member/umsmember")
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;
    @Autowired
    private CouponFeignService couponFeignService;

    @RequestMapping("/coupons")
    public R test(){
        UmsMemberEntity memberEntity = new UmsMemberEntity();
        memberEntity.setNickname("张三");
        R r = couponFeignService.memberCoupons();
        return R.ok().put("member", memberEntity).put("coupons", r.get("coupons"));
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:umsmember:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsMemberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:umsmember:info")
    public R info(@PathVariable("id") Long id){
		UmsMemberEntity umsMember = umsMemberService.getById(id);

        return R.ok().put("umsMember", umsMember);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:umsmember:save")
    public R save(@RequestBody UmsMemberEntity umsMember){
		umsMemberService.save(umsMember);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:umsmember:update")
    public R update(@RequestBody UmsMemberEntity umsMember){
		umsMemberService.updateById(umsMember);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:umsmember:delete")
    public R delete(@RequestBody Long[] ids){
		umsMemberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
