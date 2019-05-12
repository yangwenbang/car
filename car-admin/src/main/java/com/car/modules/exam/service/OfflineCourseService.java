package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.OfflineCourseEntity;

import java.util.Map;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-14 18:21:39
 */
public interface OfflineCourseService extends IService<OfflineCourseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

