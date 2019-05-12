package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.NewMsgEntity;

import java.util.Map;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-11 20:54:55
 */
public interface NewMsgService extends IService<NewMsgEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

