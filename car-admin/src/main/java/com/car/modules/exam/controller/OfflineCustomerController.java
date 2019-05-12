package com.car.modules.car.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.car.common.utils.JsonUtils;
import com.car.common.utils.PageCondition;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.OfflineCourseEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.modules.car.entity.OfflineCustomerEntity;
import com.car.modules.car.service.OfflineCustomerService;
import com.car.common.utils.PageUtils;
import com.car.common.utils.R;



/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-14 18:21:39
 */
@RestController
@RequestMapping("car/offlinecustomer")
public class OfflineCustomerController {
    @Autowired
    private OfflineCustomerService offlineCustomerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestBody String data){
        PageCondition pageCondition= JsonUtils.readValue(data,PageCondition.class);
        Map<String, Object> params=pageCondition.transferToTargetMap();
        PageUtils page = offlineCustomerService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        OfflineCustomerEntity offlineCustomer = offlineCustomerService.selectById(id);
        return R.ok().put("offlineCustomer", offlineCustomer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody String data){
        OfflineCustomerEntity offlineCustomerEntity = JsonUtils.readValue(data, OfflineCustomerEntity.class);
        ValidatorUtils.validateEntity(offlineCustomerEntity);
        if (offlineCustomerEntity .getId()== null || offlineCustomerEntity.getId() == 0) {
            offlineCustomerEntity.setCreateTime(new Date());
            offlineCustomerEntity.setUpdateTime(new Date());
            offlineCustomerService.insert(offlineCustomerEntity);
        } else {
            offlineCustomerEntity.setUpdateTime(new Date());
            offlineCustomerService.updateAllColumnById(offlineCustomerEntity);//全部更新
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        offlineCustomerService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
