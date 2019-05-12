package com.car.modules.car.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.car.common.utils.JsonUtils;
import com.car.common.utils.PageCondition;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.*;
import com.car.modules.car.entity.vo.IdVo;
import com.car.modules.car.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.common.utils.PageUtils;
import com.car.common.utils.R;


/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-25 00:01:50
 */
@RestController
@RequestMapping("car/section")
public class SectionController {
    @Autowired
    private SectionService sectionService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private ExerciseTypeService exerciseTypeService;
    @Autowired
    private ExerciseContentService exerciseContentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sectionService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list/condition")
    public R listByCondition(@RequestBody String data) {
        PageCondition pageCondition = JsonUtils.readValue(data, PageCondition.class);
        Map<String, Object> params = pageCondition.transferToTargetMap();
        PageUtils page = sectionService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        SectionEntity section = sectionService.selectById(id);

        return R.ok().put("section", section);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    /*@RequiresPermissions("car:chapter:save")*/
    public R save(@RequestBody String data) {
        SectionEntity sectionEntity = JsonUtils.readValue(data, SectionEntity.class);
        if (sectionEntity.getId() == null || sectionEntity.getId() == 0) {
            sectionEntity.setCreateTime(new Date());
            sectionEntity.setUpdateTime(new Date());
            sectionService.insert(sectionEntity);
        } else {
            sectionEntity.setUpdateTime(new Date());
            sectionService.updateAllColumnById(sectionEntity);//全部更新
        }
        ChapterEntity chapterEntity = chapterService.selectById(sectionEntity.getChapterId());
        if (chapterEntity != null) {
            List<ChapterEntity> chapterEntities = chapterEntity.selectList(new EntityWrapper<ChapterEntity>().eq("course_id", chapterEntity.getCourseId()));
            Integer sectionCount = 0;
            for (ChapterEntity item : chapterEntities) {
                Integer itemcount = sectionService.selectCount(new EntityWrapper<SectionEntity>().eq("chapter_id", item.getId()));
                sectionCount += itemcount;
            }

            CourseEntity courseEntity = courseService.selectById(chapterEntity.getCourseId());
            courseEntity.setCourseCount(sectionCount);
            courseService.updateAllColumnById(courseEntity);
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SectionEntity section) {
        ValidatorUtils.validateEntity(section);
        sectionService.updateAllColumnById(section);//全部更新

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String data) {
        IdVo idVo=JsonUtils.readValue(data,IdVo.class);
        exerciseContentService.delete(new EntityWrapper<ExerciseContentEntity>().eq("section_id",idVo.getId()));
        sectionService.deleteById(idVo.getId());
        return R.ok();
    }

    @RequestMapping("/getExerciseModel")
    public R getExerciseModel() {
        List<ExerciseTypeEntity> exerciseTypeList = exerciseTypeService.selectList(null);

        return R.ok().put("exerciseTypeList", exerciseTypeList);
    }
}
