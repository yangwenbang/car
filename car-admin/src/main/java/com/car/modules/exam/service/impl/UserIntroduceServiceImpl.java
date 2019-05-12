package com.car.modules.car.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.UserIntroduceDao;
import com.car.modules.car.entity.UserIntroduceEntity;
import com.car.modules.car.service.UserIntroduceService;


@Service("userIntroduceService")
public class UserIntroduceServiceImpl extends ServiceImpl<UserIntroduceDao, UserIntroduceEntity> implements UserIntroduceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserIntroduceEntity> page = this.selectPage(
                new Query<UserIntroduceEntity>(params).getPage(),
                new EntityWrapper<UserIntroduceEntity>()
        );

        return new PageUtils(page);
    }

}
