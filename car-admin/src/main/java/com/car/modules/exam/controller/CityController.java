package com.car.modules.car.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.common.utils.PageUtils;
import com.car.common.utils.R;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.CityEntity;
import com.car.modules.car.service.CityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-25 01:44:49
 */
@RestController
@RequestMapping("car/city")
@Api(tags = "城市管理")
public class CityController {
    @Autowired
    private CityService cityService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RequiresPermissions("car:city:list")
    @ApiOperation("城市列表")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = cityService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping(value = "/list/all")
    public R list() {
        CityEntity cityEntity = new CityEntity();
        List<CityEntity> cityList = cityEntity.selectAll();
        return R.ok().put("list", cityList);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("car:city:info")
    public R info(@PathVariable("id") Long id) {
        CityEntity city = cityService.selectById(id);

        return R.ok().put("city", city);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("car:city:save")
    public R save(@RequestBody CityEntity city) {
        cityService.insert(city);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("car:city:update")
    public R update(@RequestBody CityEntity city) {
        ValidatorUtils.validateEntity(city);
        cityService.updateAllColumnById(city);//全部更新

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("car:city:delete")
    public R delete(@RequestBody Long[] ids) {
        cityService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
