package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.MsgTypeEntity;

import java.util.Map;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-13 11:18:40
 */
public interface MsgTypeService extends IService<MsgTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryWithProject(Map<String, Object> params);
}

