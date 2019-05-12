package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.ProvinceEntity;

import java.util.Map;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-15 18:14:16
 */
public interface ProvinceService extends IService<ProvinceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

