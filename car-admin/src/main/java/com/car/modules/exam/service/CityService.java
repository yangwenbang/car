package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.CityEntity;

import java.util.Map;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-25 01:44:49
 */
public interface CityService extends IService<CityEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

