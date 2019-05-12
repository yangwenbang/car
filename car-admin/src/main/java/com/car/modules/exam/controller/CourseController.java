package com.car.modules.car.controller;

import java.io.IOException;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.car.common.utils.JsonUtils;
import com.car.common.utils.PageCondition;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.*;
import com.car.modules.car.service.*;
import com.car.modules.oss.cloud.OSSFactory;
import com.car.modules.oss.service.SysOssService;
import com.car.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.car.common.utils.PageUtils;
import com.car.common.utils.R;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-20 20:07:58
 */
@RestController
@RequestMapping("car/course")
public class CourseController extends AbstractController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private SysOssService sysOssService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TeacherService teacherService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("car:course:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = courseService.queryPage(params);
        return R.ok().put("page", page);
    }



    /**
     * 列表
     */
    @RequestMapping("/list/condition")
    @RequiresPermissions("car:course:list")
    public R list(@RequestBody String data){
        PageCondition pageCondition= JsonUtils.readValue(data,PageCondition.class);
        Map<String, Object> params=pageCondition.transferToTargetMap();
        PageUtils page = courseService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("car:course:info")
    public R info(@PathVariable("id") Long id){
        CourseEntity course = courseService.selectById(id);
        return R.ok().put("course", course);
    }



    /**
     * 修改
     */
    @RequestMapping("/update/effective")
    @RequiresPermissions("car:course:save")
    public R updateEffective(@RequestBody String data) throws IOException {
        CourseEntity courseEntity = JSON.parseObject(data, CourseEntity.class);
        if (courseEntity == null) {
            return R.error("参数异常");
        }
        else{
           CourseEntity courseEntityDb =courseService.selectById(courseEntity.getId());
           courseEntityDb.setUpdateTime(new Date());
           courseEntityDb.setEffective(courseEntity.getEffective());
           courseService.updateAllColumnById(courseEntityDb);
           return R.ok("更新成功");
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/save")
    @RequiresPermissions("car:course:save")
    public R save(@RequestBody String data) throws IOException {
        CourseEntity courseEntity = JSON.parseObject(data, CourseEntity.class);
        if(courseEntity==null){
            return R.error("参数异常");
        }
        Long categoryId = courseEntity.getCategoryId();
        Long projectId = courseEntity.getProjectId();
        Long teacherId = courseEntity.getTeacherId();
        Long subjectId = courseEntity.getSubjectId();
        String userName=getUser().getUsername();
        courseEntity.setReplayUsername(userName);
        if(categoryId != null && !categoryId.equals("")){
            CategoryEntity category = categoryService.selectOne(new EntityWrapper<CategoryEntity>().setSqlSelect("category_name").eq("id",categoryId));
            courseEntity.setCategoryName(category.getCategoryName());
        }
        if(projectId != null && !projectId.equals("")){
            ProjectEntity project = projectService.selectOne(new EntityWrapper<ProjectEntity>().setSqlSelect("project_name").eq("id", projectId));
            courseEntity.setProjectName(project.getProjectName());
        }
//        if(teacherId != null && !teacherId.equals("")){
//            TeacherEntity teacher = teacherService.selectOne(new EntityWrapper<TeacherEntity>().setSqlSelect("teacher_name").eq("id",teacherId));
//            courseEntity.setTeacherName(teacher.getTeacherName());
//        }
        if(subjectId != null  && !subjectId.equals("")){
            SubjectEntity subject = subjectService.selectOne(new EntityWrapper<SubjectEntity>().setSqlSelect("subject_name").eq("id",subjectId));
            courseEntity.setSubjectName(subject.getSubjectName());
        }
        courseEntity.setUpdateTime(new Date());
        courseEntity.setReplayDate(new Date());
        ValidatorUtils.validateEntity(courseEntity);
        if(courseEntity.getId()==null||courseEntity.getId()==0){
            courseEntity.setCreateDate(new Date());
            courseEntity.setUpdateTime(new Date());
            courseService.insert(courseEntity);
        }else {
            courseEntity.setUpdateTime(new Date());
            courseService.updateAllColumnById(courseEntity);//全部更新
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("car:course:delete")
    public R delete(@RequestBody Long[] ids){
        courseService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    @RequestMapping("/updateLoad")
    public R updateLoad(@RequestBody CourseEntity courseEntity) {
        TeacherEntity teacherEntity = new TeacherEntity();
        ProjectEntity projectEntity = new ProjectEntity();
        Map<String, Object> course = new HashMap<String, Object>();
        List<TeacherEntity> teacherList = teacherEntity.selectAll();
        List<ProjectEntity> projectList = projectEntity.selectAll();
        course.put("teacherList",teacherList);
        if (projectList == null || projectList.isEmpty() || courseEntity == null || courseEntity.getProjectId() == null){
            return R.ok().put("course",course);
        }
        course.put("projectList",projectList);
        List<CategoryEntity> categoryList = categoryService.selectList(new EntityWrapper<CategoryEntity>().eq("project_id", courseEntity.getProjectId()));
            if(categoryList == null || categoryList.isEmpty() || courseEntity == null || courseEntity.getCategoryId() == null){
                return R.ok().put("course",course);
            }
        course.put("categoryList",categoryList);
        Long categoryId = categoryList.get(0).getId();
        List<SubjectEntity> subjectList = subjectService.selectList(new EntityWrapper<SubjectEntity>().eq("project_id", courseEntity.getProjectId()).eq("category_id",courseEntity.getCategoryId()));
        course.put("subjectList",subjectList);
        return R.ok().put("course",course);
    }
    @RequestMapping("/selectLoad")
    public R selectLoad() {
        ProjectEntity projectEntity = new ProjectEntity();
        CategoryEntity categoryEntity = new CategoryEntity();
        Map<String, Object> course = new HashMap<String, Object>();
        List<CategoryEntity> categoryList = categoryEntity.selectAll();
        List<ProjectEntity> projectList = projectEntity.selectAll();
        course.put("projectList",projectList);
        course.put("categoryList",categoryList);
        return R.ok().put("course",course);
    }
    @RequestMapping("/addLoad")
    public R addLoad() {
        TeacherEntity teacherEntity = new TeacherEntity();
        ProjectEntity projectEntity = new ProjectEntity();
        Map<String, Object> course = new HashMap<String, Object>();
        List<TeacherEntity> teacherList = teacherEntity.selectAll();
        List<ProjectEntity> projectList = projectEntity.selectAll();
        course.put("teacherList",teacherList);
        if (projectList == null || projectList.isEmpty()){
            return R.ok().put("course",course);
        }
        course.put("projectList",projectList);
        Long projectId = projectList.get(0).getId();
        List<CategoryEntity> categoryList = categoryService.selectList(new EntityWrapper<CategoryEntity>().eq("project_id", projectId));
            if(categoryList == null || categoryList.isEmpty()){
                return R.ok().put("course",course);
            }
        course.put("categoryList",categoryList);
        Long categoryId = categoryList.get(0).getId();
        List<SubjectEntity> subjectList = subjectService.selectList(new EntityWrapper<SubjectEntity>().eq("project_id", projectId).eq("category_id",categoryId));
        course.put("subjectList",subjectList);
        return R.ok().put("course",course);
    }

    @RequestMapping("/categoryData")
    public R categoryData(@RequestParam(value = "projectId", required = false)String projectId){
        if(projectId == null || projectId.equals("")){
            return R.ok();
        }
        List<CategoryEntity> categoryList = categoryService.selectList(new EntityWrapper<CategoryEntity>().eq("project_id", projectId));
        return R.ok().put("categoryList",categoryList);
    }

    @RequestMapping("/subjectData")
    public R subjectData(@RequestBody SubjectEntity subject) {
        Long projectId = subject.getProjectId();
        Long categoryId = subject.getCategoryId();
        if(projectId == null || projectId.equals("") || categoryId == null || categoryId.equals("")){
            return R.ok();
        }
        List<SubjectEntity> subjectList = subjectService.selectList(new EntityWrapper<SubjectEntity>().eq("project_id", projectId).eq("category_id",categoryId));
        return R.ok().put("subjectList",subjectList);
    }
}
