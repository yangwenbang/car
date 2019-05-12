package com.car.modules.car.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.car.common.utils.JsonUtils;
import com.car.common.utils.PageCondition;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.ExerciseTypeEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.modules.car.entity.ProjectEntity;
import com.car.modules.car.service.ProjectService;
import com.car.common.utils.PageUtils;
import com.car.common.utils.R;


/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-23 00:54:34
 */
@RestController
@RequestMapping("car/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("car:project:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = projectService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list/all")
    public R listAll() {
        List<ProjectEntity> projects = projectService.selectList();
        return R.ok().put("list", projects);
    }


    /**
     * 列表
     */
    @RequestMapping("/list/condition")
    public R list(@RequestBody String data) {
        PageCondition pageCondition = JsonUtils.readValue(data, PageCondition.class);
        Map<String, Object> params = pageCondition.transferToTargetMap();
        PageUtils page = projectService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("car:project:info")
    public R info(@PathVariable("id") Long id) {
        ProjectEntity project = projectService.selectById(id);

        return R.ok().put("project", project);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody String data) {
        ProjectEntity projectEntity = JsonUtils.readValue(data, ProjectEntity.class);
        ValidatorUtils.validateEntity(projectEntity);
        if (projectEntity.getId() == null || projectEntity.getId() == 0) {
            projectEntity.setEffective(1);
            projectService.insert(projectEntity);
        } else {
            projectService.updateAllColumnById(projectEntity);//全部更新
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("car:project:update")
    public R update(@RequestBody ProjectEntity project) {
        ValidatorUtils.validateEntity(project);
        projectService.updateAllColumnById(project);//全部更新

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("car:project:delete")
    public R delete(@RequestBody Long[] ids) {
        projectService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
