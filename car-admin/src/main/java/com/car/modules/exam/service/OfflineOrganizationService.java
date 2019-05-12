package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.OfflineOrganizationEntity;

import java.util.Map;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-14 18:21:39
 */
public interface OfflineOrganizationService extends IService<OfflineOrganizationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

