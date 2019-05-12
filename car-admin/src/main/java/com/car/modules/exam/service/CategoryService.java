package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.CategoryEntity;

import java.util.Map;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-23 00:54:45
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

