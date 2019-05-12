package com.car.modules.car.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.MsgTypeEntity;
import com.car.modules.car.entity.ProjectEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.modules.car.entity.ProvinceEntity;
import com.car.modules.car.service.ProvinceService;
import com.car.common.utils.PageUtils;
import com.car.common.utils.R;


/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-15 18:14:16
 */
@RestController
@RequestMapping("car/province")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("car:province:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = provinceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 列表
     */
    @RequestMapping("/all")
    public R list() {
        List<ProvinceEntity> list = provinceService.selectList(new EntityWrapper<ProvinceEntity>().eq("effective", 1));
        return R.ok().put("list", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("car:province:info")
    public R info(@PathVariable("id") Long id) {
        ProvinceEntity province = provinceService.selectById(id);

        return R.ok().put("province", province);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("car:province:save")
    public R save(@RequestBody ProvinceEntity province) {
        provinceService.insert(province);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("car:province:update")
    public R update(@RequestBody ProvinceEntity province) {
        ValidatorUtils.validateEntity(province);
        provinceService.updateAllColumnById(province);//全部更新

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("car:province:delete")
    public R delete(@RequestBody Long[] ids) {
        provinceService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
