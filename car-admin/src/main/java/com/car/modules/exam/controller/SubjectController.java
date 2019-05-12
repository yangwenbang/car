package com.car.modules.car.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.car.common.utils.JsonUtils;
import com.car.common.utils.PageCondition;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.CategoryEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.modules.car.entity.SubjectEntity;
import com.car.modules.car.service.SubjectService;
import com.car.common.utils.PageUtils;
import com.car.common.utils.R;


/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-23 00:54:34
 */
@RestController
@RequestMapping("car/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("car:subject:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = subjectService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list/condition")
    public R listByCondition(@RequestBody String data) {
        PageCondition pageCondition = JsonUtils.readValue(data, PageCondition.class);
        Map<String, Object> params = pageCondition.transferToTargetMap();
        PageUtils page = subjectService.queryPage(params);
        return R.ok().put("page", page);
    }


    @RequestMapping("/list/category/{categoryId}")
    public R queryByProjectId(@PathVariable("categoryId") Long categoryId){
        List<SubjectEntity> subjectEntities = subjectService.selectList(new EntityWrapper<SubjectEntity>().eq("category_id",categoryId));
        return R.ok().put("list", subjectEntities);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("car:subject:info")
    public R info(@PathVariable("id") Long id) {
        SubjectEntity subject = subjectService.selectById(id);
        return R.ok().put("subject", subject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody String data) {
        SubjectEntity subjectEntity = JsonUtils.readValue(data, SubjectEntity.class);
        ValidatorUtils.validateEntity(subjectEntity);
        if (subjectEntity.getId() == null || subjectEntity.getId() == 0) {
            subjectEntity.setCreateTime(new Date());
            subjectEntity.setUpdateTime(new Date());
            subjectEntity.setEffective(1);
            subjectService.insert(subjectEntity);
        } else {
            subjectEntity.setUpdateTime(new Date());
            subjectService.updateAllColumnById(subjectEntity);//全部更新
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("car:subject:update")
    public R update(@RequestBody SubjectEntity subject) {
        ValidatorUtils.validateEntity(subject);
        subjectService.updateAllColumnById(subject);//全部更新

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("car:subject:delete")
    public R delete(@RequestBody Long[] ids) {
        subjectService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
