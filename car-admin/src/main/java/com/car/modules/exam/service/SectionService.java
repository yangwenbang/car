package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.SectionEntity;

import java.util.Map;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-25 00:01:50
 */
public interface SectionService extends IService<SectionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

