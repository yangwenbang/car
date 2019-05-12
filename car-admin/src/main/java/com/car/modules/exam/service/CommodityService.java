package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.CommodityEntity;

import java.util.Map;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-14 15:46:53
 */
public interface CommodityService extends IService<CommodityEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

