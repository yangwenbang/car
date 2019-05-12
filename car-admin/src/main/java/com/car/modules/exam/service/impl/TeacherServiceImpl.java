package com.car.modules.car.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.car.modules.car.dao.TeacherDao;
import com.car.modules.car.entity.CourseEntity;
import com.car.modules.car.entity.TeacherEntity;
import com.car.modules.car.entity.vo.TeacherVO;
import com.car.modules.car.service.TeacherService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;


@Service("teacherService")
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, TeacherEntity> implements TeacherService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String teacherName = (String) params.get("teacherName");
        Page<TeacherVO> page = new Query<TeacherVO>(params).getPage();
        Wrapper<TeacherEntity> wrapper = new EntityWrapper<TeacherEntity>().like(StringUtils.isNotBlank(teacherName), "teacher_name", teacherName);
        page = page.setRecords(this.baseMapper.strengSelectPage(page, wrapper, teacherName));

        return new PageUtils(page);
    }

}
