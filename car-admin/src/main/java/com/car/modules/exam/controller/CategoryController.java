package com.car.modules.car.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.car.common.utils.JsonUtils;
import com.car.common.utils.PageCondition;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.ProjectEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.modules.car.entity.CategoryEntity;
import com.car.modules.car.service.CategoryService;
import com.car.common.utils.PageUtils;
import com.car.common.utils.R;



/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-23 00:54:45
 */
@RestController
@RequestMapping("car/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("car:category:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 列表
     */
    @RequestMapping("/list/condition")
    public R list(@RequestBody String data){
        PageCondition pageCondition = JsonUtils.readValue(data, PageCondition.class);
        Map<String, Object> params = pageCondition.transferToTargetMap();
        PageUtils page = categoryService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("car:category:info")
    public R info(@PathVariable("id") Long id){
        CategoryEntity category = categoryService.selectById(id);

        return R.ok().put("category", category);
    }


    @RequestMapping("/list/project/{projectId}")
    public R queryByProjectId(@PathVariable("projectId") Long projectId){
        List<CategoryEntity> categoryEntities = categoryService.selectList(new EntityWrapper<CategoryEntity>().eq("project_id",projectId));
        return R.ok().put("list", categoryEntities);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody String  data){
        CategoryEntity categoryEntity = JsonUtils.readValue(data, CategoryEntity.class);
        ValidatorUtils.validateEntity(categoryEntity);
        if (categoryEntity.getId() == null || categoryEntity.getId() == 0) {
            categoryEntity.setCreateDate(new Date());
            categoryEntity.setUpdateTime(new Date());
            categoryEntity.setEffective(1);
            categoryService.insert(categoryEntity);
        } else {
            categoryEntity.setUpdateTime(new Date());
            categoryService.updateAllColumnById(categoryEntity);//全部更新
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("car:category:update")
    public R update(@RequestBody CategoryEntity category){
        ValidatorUtils.validateEntity(category);
        categoryService.updateAllColumnById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("car:category:delete")
    public R delete(@RequestBody Long[] ids){
        categoryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
