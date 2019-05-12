package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.ExerciseContentEntity;

import java.util.Map;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-02-11 14:51:15
 */
public interface ExerciseContentService extends IService<ExerciseContentEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils strengSelectPage(Map<String, Object> params);
}

