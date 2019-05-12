package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.UserIntroduceEntity;

import java.util.Map;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-25 21:51:02
 */
public interface UserIntroduceService extends IService<UserIntroduceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

