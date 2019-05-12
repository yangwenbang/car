package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.CourseEntity;
import com.car.modules.car.entity.TeacherEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-20 20:07:58
 */
public interface CourseService extends IService<CourseEntity> {

    PageUtils queryPage(Map<String, Object> params);

}

