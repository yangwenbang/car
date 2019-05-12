package com.car.modules.car.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.car.common.utils.JsonUtils;
import com.car.common.utils.PageCondition;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.CourseEntity;
import com.car.modules.car.entity.ExerciseModelEntity;
import com.car.modules.car.entity.vo.IdVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.modules.car.entity.ChapterEntity;
import com.car.modules.car.service.ChapterService;
import com.car.common.utils.PageUtils;
import com.car.common.utils.R;



/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-25 00:01:28
 */
@RestController
@RequestMapping("car/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    /*@RequiresPermissions("car:chapter:list")*/
    public R list(@RequestParam Map<String, Object> params){
        //chapterService.selectList(new EntityWrapper<ChapterEntity>());
        PageUtils page = chapterService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list/condition")
    public R listByCondition(@RequestBody String data){
        PageCondition pageCondition = JsonUtils.readValue(data, PageCondition.class);
        Map<String, Object> params = pageCondition.transferToTargetMap();
        PageUtils page = chapterService.queryPage(params);
        return R.ok().put("page", page);
    }




    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    /*@RequiresPermissions("car:chapter:info")*/
    public R info(@PathVariable("id") Long id){
        ChapterEntity chapter = chapterService.selectById(id);

        return R.ok().put("chapter", chapter);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    /*@RequiresPermissions("car:chapter:save")*/
    public R save(@RequestBody String data){
        ChapterEntity chapter = JsonUtils.readValue(data, ChapterEntity.class);
        if (chapter.getId() == null || chapter.getId() == 0) {
            chapter.setCreateDate(new Date());
            chapter.setUpdateTime(new Date());
            chapterService.insert(chapter);
        } else {
            chapter.setUpdateTime(new Date());
            chapterService.updateAllColumnById(chapter);//全部更新
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    /*@RequiresPermissions("car:chapter:update")*/
    public R update(@RequestBody ChapterEntity chapter){
        chapter.setUpdateTime(new Date());
        ValidatorUtils.validateEntity(chapter);
        chapterService.updateAllColumnById(chapter);//全部更新

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    /*@RequiresPermissions("car:chapter:delete")*/
    public R delete(@RequestBody String data){
        IdVo idVo = JsonUtils.readValue(data, IdVo.class);
        chapterService.deleteById(idVo.getId());
        return R.ok();
    }

    @RequestMapping("/addLoad")
    public R addLoad(){
        CourseEntity courseEntity = new CourseEntity();
        List<CourseEntity> courseList = courseEntity.selectAll();
        return R.ok().put("courseList",courseList);
    }

}
