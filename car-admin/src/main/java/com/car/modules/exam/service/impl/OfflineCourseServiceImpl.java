package com.car.modules.car.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.OfflineCourseDao;
import com.car.modules.car.entity.OfflineCourseEntity;
import com.car.modules.car.service.OfflineCourseService;


@Service("offlineCourseService")
public class OfflineCourseServiceImpl extends ServiceImpl<OfflineCourseDao, OfflineCourseEntity> implements OfflineCourseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OfflineCourseEntity> page = this.selectPage(
                new Query<OfflineCourseEntity>(params).getPage(),
                new EntityWrapper<OfflineCourseEntity>()
        );

        return new PageUtils(page);
    }

}
