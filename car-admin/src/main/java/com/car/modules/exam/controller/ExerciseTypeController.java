package com.car.modules.car.controller;

import com.car.common.utils.JsonUtils;
import com.car.common.utils.PageCondition;
import com.car.common.utils.PageUtils;
import com.car.common.utils.R;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.ExerciseModelEntity;
import com.car.modules.car.entity.ExerciseTypeEntity;
import com.car.modules.car.entity.vo.IdVo;
import com.car.modules.car.service.ExerciseModelService;
import com.car.modules.car.service.ExerciseTypeService;
import com.car.modules.car.service.ProjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-02-11 14:51:15
 */
@RestController
@RequestMapping("car/exercisetype")
public class ExerciseTypeController {
    @Autowired
    private ExerciseTypeService exerciseTypeService;

    @Autowired
    private ExerciseModelService exerciseModelService;

    @Autowired
    private ProjectService projectService;


    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("car:exercisetype:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = exerciseTypeService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 列表
     */
    @RequestMapping("/list/condition")
    @RequiresPermissions("car:exercisetype:list")
    public R listByCondition(@RequestBody String data) {
        PageCondition pageCondition = JsonUtils.readValue(data, PageCondition.class);
        Map<String, Object> params = pageCondition.transferToTargetMap();
        PageUtils page = exerciseTypeService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/model/list/condition")
    @RequiresPermissions("car:exercisetype:list")
    public R modelListByCondition(@RequestBody String data) {
        PageCondition pageCondition = JsonUtils.readValue(data, PageCondition.class);
        Map<String, Object> params = pageCondition.transferToTargetMap();
        PageUtils page = exerciseModelService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/model/list/all")
    @RequiresPermissions("car:exercisetype:list")
    public R queryModelListAll() {
        List<ExerciseModelEntity> exerciseModelEntities = exerciseModelService.queryListAll();
        return R.ok().put("list", exerciseModelEntities);
    }


    @RequestMapping("/list/all")
    @RequiresPermissions("car:exercisetype:list")
    public R queryListAll() {
        List<ExerciseTypeEntity> exerciseTypeEntities = exerciseTypeService.queryAll();
        return R.ok().put("list", exerciseTypeEntities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info")
    public R info(@RequestBody String data) {
        IdVo idVo = JsonUtils.readValue(data, IdVo.class);
        ExerciseTypeEntity exerciseType = exerciseTypeService.selectById(idVo.getId());
        return R.ok().put("exerciseType", exerciseType);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody String data) {
        ExerciseTypeEntity exerciseType = JsonUtils.readValue(data, ExerciseTypeEntity.class);
        ValidatorUtils.validateEntity(exerciseType);
        if (exerciseType.getId() == null || exerciseType.getId() == 0) {
            exerciseTypeService.insert(exerciseType);
        } else {
            exerciseTypeService.updateAllColumnById(exerciseType);//全部更新
        }
        return R.ok();
    }

    /**
     * 保存
     */
    @RequestMapping("/save/patch")
    public R pathcSave(@RequestBody String data) {
        List<ExerciseTypeEntity> exerciseTypes = JsonUtils.readValueByList(data, ExerciseTypeEntity.class);
        for (ExerciseTypeEntity exerciseType : exerciseTypes) {
            ValidatorUtils.validateEntity(exerciseType);
        }
        exerciseTypeService.insertBatch(exerciseTypes);
        return R.ok();
    }

    /**
     * 保存
     */
    @RequestMapping("/model/save")
    public R modelSave(@RequestBody String data) {
        ExerciseModelEntity exerciseModelEntity = JsonUtils.readValue(data, ExerciseModelEntity.class);
        if (exerciseModelEntity.getId() == null || exerciseModelEntity.getId() == 0) {
            exerciseModelEntity.setCreateTime(new Date());
            exerciseModelEntity.setUpdateTime(new Date());
            exerciseModelService.insert(exerciseModelEntity);
        } else {
            exerciseModelEntity.setUpdateTime(new Date());
            exerciseModelService.updateAllColumnById(exerciseModelEntity);//全部更新
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody String data) {
        ExerciseTypeEntity exerciseType = JsonUtils.readValue(data, ExerciseTypeEntity.class);
        ValidatorUtils.validateEntity(exerciseType);
        exerciseTypeService.updateAllColumnById(exerciseType);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String data) {
        IdVo idVo = JsonUtils.readValue(data, IdVo.class);
        exerciseTypeService.deleteById(idVo.getId());
        return R.ok();
    }


    //todo:需要判定逻辑

    /**
     * 删除
     */
    @RequestMapping("/model/delete")
    public R modelDelete(@RequestBody String data) {
        IdVo idVo = JsonUtils.readValue(data, IdVo.class);
        exerciseModelService.deleteById(idVo.getId());
        return R.ok();
    }


}
