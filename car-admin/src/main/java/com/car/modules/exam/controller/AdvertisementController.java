package com.car.modules.car.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.car.common.utils.JsonUtils;
import com.car.common.utils.PageCondition;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.NewMsgEntity;
import com.car.modules.car.entity.vo.IdVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.modules.car.entity.AdvertisementEntity;
import com.car.modules.car.service.AdvertisementService;
import com.car.common.utils.PageUtils;
import com.car.common.utils.R;



/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-13 14:59:04
 */
@RestController
@RequestMapping("car/advertisement")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestBody String  data){
        PageCondition pageCondition = JsonUtils.readValue(data, PageCondition.class);
        Map<String, Object> params = pageCondition.transferToTargetMap();
        PageUtils page = advertisementService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AdvertisementEntity advertisement = advertisementService.selectById(id);
        return R.ok().put("advertisement", advertisement);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody String  data){
        AdvertisementEntity advertisementEntity = JSON.parseObject(data, AdvertisementEntity.class);
        if (advertisementEntity.getId() == null || advertisementEntity.getId() == 0) {
            advertisementEntity.setCreateDate(new Date());
            advertisementService.insert(advertisementEntity);
        } else {
            advertisementService.updateAllColumnById(advertisementEntity);//全部更新
        }
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("car:advertisement:delete")
    public R delete(@RequestBody String  data){
        IdVo idVo = JsonUtils.readValue(data, IdVo.class);
        advertisementService.deleteById(idVo.getId());
        return R.ok();
    }
}
