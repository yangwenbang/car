package com.car.modules.car.controller;

import com.car.common.utils.JsonUtils;
import com.car.common.utils.PageCondition;
import com.car.common.utils.PageUtils;
import com.car.common.utils.R;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.OfflineCourseEntity;
import com.car.modules.car.service.OfflineCourseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;



/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-14 18:21:39
 */
@RestController
@RequestMapping("car/offlinecourse")
public class OfflineCourseController {
    @Autowired
    private OfflineCourseService offlineCourseService;

    /**

     /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestBody String data){
        PageCondition pageCondition= JsonUtils.readValue(data,PageCondition.class);
        Map<String, Object> params=pageCondition.transferToTargetMap();
        PageUtils page = offlineCourseService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        OfflineCourseEntity offlineCourseEntity = offlineCourseService.selectById(id);
        return R.ok().put("offlineCourseEntity", offlineCourseEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody String data){
        OfflineCourseEntity offlineCourseEntity = JsonUtils.readValue(data, OfflineCourseEntity.class);
        ValidatorUtils.validateEntity(offlineCourseEntity);
        if (offlineCourseEntity .getId()== null || offlineCourseEntity.getId() == 0) {
            offlineCourseEntity.setCreateTime(new Date());
            offlineCourseEntity.setUpdateTime(new Date());
            offlineCourseService.insert(offlineCourseEntity);
        } else {
            offlineCourseEntity.setUpdateTime(new Date());
            offlineCourseService.updateAllColumnById(offlineCourseEntity);//全部更新
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("car:offlineorganization:delete")
    public R delete(@RequestBody Long[] ids){
        offlineCourseService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
