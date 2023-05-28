package com.jhb.shopping.order.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhb.shopping.order.entity.OmsOrderSettingEntity;
import com.jhb.shopping.order.service.OmsOrderSettingService;
import com.jhb.common.utils.PageUtils;
import com.jhb.common.utils.R;



/**
 * 订单配置信息
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:15:21
 */
@RestController
@RequestMapping("order/omsordersetting")
public class OmsOrderSettingController {
    @Autowired
    private OmsOrderSettingService omsOrderSettingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:omsordersetting:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = omsOrderSettingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:omsordersetting:info")
    public R info(@PathVariable("id") Long id){
		OmsOrderSettingEntity omsOrderSetting = omsOrderSettingService.getById(id);

        return R.ok().put("omsOrderSetting", omsOrderSetting);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:omsordersetting:save")
    public R save(@RequestBody OmsOrderSettingEntity omsOrderSetting){
		omsOrderSettingService.save(omsOrderSetting);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:omsordersetting:update")
    public R update(@RequestBody OmsOrderSettingEntity omsOrderSetting){
		omsOrderSettingService.updateById(omsOrderSetting);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:omsordersetting:delete")
    public R delete(@RequestBody Long[] ids){
		omsOrderSettingService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
