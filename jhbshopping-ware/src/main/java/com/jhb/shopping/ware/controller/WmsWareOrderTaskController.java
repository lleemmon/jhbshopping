package com.jhb.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhb.shopping.ware.entity.WmsWareOrderTaskEntity;
import com.jhb.shopping.ware.service.WmsWareOrderTaskService;
import com.jhb.common.utils.PageUtils;
import com.jhb.common.utils.R;



/**
 * 库存工作单
 *
 * @author jianghuibin
 * @email 574438083@qq.com
 * @date 2023-05-27 14:18:51
 */
@RestController
@RequestMapping("ware/wmswareordertask")
public class WmsWareOrderTaskController {
    @Autowired
    private WmsWareOrderTaskService wmsWareOrderTaskService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:wmswareordertask:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = wmsWareOrderTaskService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:wmswareordertask:info")
    public R info(@PathVariable("id") Long id){
		WmsWareOrderTaskEntity wmsWareOrderTask = wmsWareOrderTaskService.getById(id);

        return R.ok().put("wmsWareOrderTask", wmsWareOrderTask);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:wmswareordertask:save")
    public R save(@RequestBody WmsWareOrderTaskEntity wmsWareOrderTask){
		wmsWareOrderTaskService.save(wmsWareOrderTask);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:wmswareordertask:update")
    public R update(@RequestBody WmsWareOrderTaskEntity wmsWareOrderTask){
		wmsWareOrderTaskService.updateById(wmsWareOrderTask);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:wmswareordertask:delete")
    public R delete(@RequestBody Long[] ids){
		wmsWareOrderTaskService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
