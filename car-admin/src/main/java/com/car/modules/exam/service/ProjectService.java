package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.ProjectEntity;

import java.util.List;
import java.util.Map;

/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-23 00:54:34
 */
public interface ProjectService extends IService<ProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询所有
     *
     * @return
     */
    List<ProjectEntity> selectList();

    /**
     * 查询所有
     *
     * @return
     */
    Map<Long, ProjectEntity> selectMaps();
}

