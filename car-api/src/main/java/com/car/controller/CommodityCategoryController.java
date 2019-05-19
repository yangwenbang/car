package com.car.controller;

import java.util.Map;

import com.car.common.validator.ValidatorUtils;
import com.car.entity.CommodityCategoryEntity;
import com.car.form.CommodityForm;
import com.car.service.CommodityCategoryService;
import com.car.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.car.common.utils.R;



/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 21:32:24
 */
@RestController
@RequestMapping("car/commoditycategory")
public class CommodityCategoryController {

    @Autowired
    private CommodityCategoryService commodityCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        return R.ok();
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        return R.ok();
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody CommodityForm commodityForm){
        return new Result();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CommodityCategoryEntity commodityCategory){
        ValidatorUtils.validateEntity(commodityCategory);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        return R.ok();
    }

}
