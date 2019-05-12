package com.car.modules.car.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.UserDetailDao;
import com.car.modules.car.entity.UserDetailEntity;
import com.car.modules.car.service.UserDetailService;


@Service("userDetailService")
public class UserDetailServiceImpl extends ServiceImpl<UserDetailDao, UserDetailEntity> implements UserDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserDetailEntity> page = this.selectPage(
                new Query<UserDetailEntity>(params).getPage(),
                new EntityWrapper<UserDetailEntity>()
        );

        return new PageUtils(page);
    }

}
