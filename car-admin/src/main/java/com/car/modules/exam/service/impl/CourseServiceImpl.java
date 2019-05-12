package com.car.modules.car.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;
import com.car.modules.car.dao.CourseDao;
import com.car.modules.car.entity.CourseEntity;
import com.car.modules.car.service.CourseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseDao, CourseEntity> implements CourseService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String courseName = (String) params.get("courseName");
        String categoryId = (String) params.get("categoryId");
        String projectId = (String) params.get("projectId");
        String subjectId = (String) params.get("subjectId");
        Page<CourseEntity> page = this.selectPage(
                new Query<CourseEntity>(params).getPage(),
                new EntityWrapper<CourseEntity>().
                        like(StringUtils.isNotBlank(courseName), "course_name", courseName).
                        eq(StringUtils.isNotBlank(categoryId), "category_id", categoryId).
                        eq(StringUtils.isNotBlank(subjectId), "subject_id", subjectId).
                        eq(StringUtils.isNotBlank(projectId), "project_id", projectId)

        );

        return new PageUtils(page);
    }
}
