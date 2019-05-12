package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.AdvertisementEntity;

import java.util.Map;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-13 14:59:04
 */
public interface AdvertisementService extends IService<AdvertisementEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

