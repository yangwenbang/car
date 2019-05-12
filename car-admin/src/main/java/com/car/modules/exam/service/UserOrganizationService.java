package com.car.modules.car.service;

import com.baomidou.mybatisplus.service.IService;
import com.car.common.utils.PageUtils;
import com.car.modules.car.entity.UserOrganizationEntity;

import java.util.Map;

/**
 * 合作伙伴机构关联表
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-22 15:40:27
 */
public interface UserOrganizationService extends IService<UserOrganizationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

