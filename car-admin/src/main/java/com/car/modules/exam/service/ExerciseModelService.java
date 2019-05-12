package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.ExerciseModelEntity;
import com.car.modules.car.entity.ProjectEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-02-11 14:51:15
 */
public interface ExerciseModelService extends IService<ExerciseModelEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询所有
     * @return
     */
    List<ExerciseModelEntity> queryAll();

    /**
     * 查询所有
     *
     * @return
     */
    Map<Long, ExerciseModelEntity> queryAllMaps();

    List<ExerciseModelEntity> queryListAll();

}

