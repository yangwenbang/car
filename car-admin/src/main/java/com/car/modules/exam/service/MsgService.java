package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.CategoryEntity;

import java.util.Map;

public interface MsgService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}