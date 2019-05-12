package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.TeacherEntity;

import java.util.Map;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-22 19:04:25
 */
public interface TeacherService extends IService<TeacherEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

