package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.UserDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-22 15:40:26
 */
public interface UserDetailService extends IService<UserDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

