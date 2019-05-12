package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.ExerciseTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-02-11 14:51:15
 */
public interface ExerciseTypeService extends IService<ExerciseTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ExerciseTypeEntity>queryAll();
}

