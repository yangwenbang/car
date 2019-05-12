package com.car.modules.car.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.UserOrganizationDao;
import com.car.modules.car.entity.UserOrganizationEntity;
import com.car.modules.car.service.UserOrganizationService;


@Service("userOrganizationService")
public class UserOrganizationServiceImpl extends ServiceImpl<UserOrganizationDao, UserOrganizationEntity> implements UserOrganizationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserOrganizationEntity> page = this.selectPage(
                new Query<UserOrganizationEntity>(params).getPage(),
                new EntityWrapper<UserOrganizationEntity>()
        );

        return new PageUtils(page);
    }

}
