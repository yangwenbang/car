package com.car.modules.car.controller;

import java.io.IOException;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.car.common.utils.JsonUtils;
import com.car.common.utils.PageCondition;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.CityEntity;
import com.car.modules.car.entity.SubjectEntity;
import com.car.modules.car.entity.TeacherEntity;
import com.car.modules.car.service.CityService;
import com.car.modules.car.service.SubjectService;
import com.car.modules.car.service.TeacherService;
import com.car.modules.oss.cloud.OSSFactory;
import com.car.modules.oss.entity.SysOssEntity;
import com.car.modules.oss.service.SysOssService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.common.utils.PageUtils;
import com.car.common.utils.R;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-22 19:04:25
 */
@RestController
@RequestMapping("car/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private SysOssService sysOssService;
    @Autowired
    private CityService cityService;
    @Autowired
    private SubjectService subjectService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("car:teacher:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = teacherService.queryPage(params);
        System.out.print(page);
        return R.ok().put("page", page);
    }
    /**
     * 所有用户列表
     */
    @RequestMapping("/list/condition")
    @RequiresPermissions("sys:user:list")
    public R listByCondition(@RequestBody String data) {
        PageCondition pageCondition = JsonUtils.readValue(data, PageCondition.class);
        Map<String, Object> params = pageCondition.transferToTargetMap();
        PageUtils page = teacherService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("car:teacher:info")
    public R info(@PathVariable("id") Long id){
        Map<String, Object> teacher = new HashMap<String, Object>();
        TeacherEntity teacherEntity = teacherService.selectById(id);
        CityEntity cityEntity = cityService.selectById(teacherEntity.getCityId());
        SubjectEntity subjectEntity = subjectService.selectById(teacherEntity.getSubjectName());
        teacher.put("cityEntity",cityEntity);
        teacher.put("teacherEntity",teacherEntity);
        teacher.put("subjectEntity",subjectEntity);
        return R.ok().put("teacher", teacher);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("car:teacher:save")
    public R save(@RequestBody String data) throws IOException {
        TeacherEntity teacherEntity = JsonUtils.readValue(data, TeacherEntity.class);
        if (teacherEntity.getId() == null || teacherEntity.getId() == 0) {
            teacherEntity.setCreateTime(new Date());
            teacherEntity.setUpdateTime(new Date());
            teacherService.insert(teacherEntity);
        } else {
            teacherEntity.setUpdateTime(new Date());
            teacherService.updateAllColumnById(teacherEntity);//全部更新
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("car:teacher:delete")
    public R delete(@RequestBody Long[] ids){
        teacherService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    @RequestMapping("/load")
    public R listLoad() {
        CityEntity cityEntity = new CityEntity();
        SubjectEntity subjectEntity = new SubjectEntity();
        Map<String, Object> teacher = new HashMap<String, Object>();
        List<CityEntity> cityList = cityEntity.selectAll();
        List<SubjectEntity> subjectList = subjectEntity.selectAll();
        teacher.put("cityList",cityList);
        teacher.put("subjectList",subjectList);
        return R.ok().put("teacher",teacher);
    }
}
