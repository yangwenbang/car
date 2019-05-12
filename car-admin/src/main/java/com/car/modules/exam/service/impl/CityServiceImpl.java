package com.car.modules.car.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.CityDao;
import com.car.modules.car.entity.CityEntity;
import com.car.modules.car.service.CityService;


@Service("cityService")
public class CityServiceImpl extends ServiceImpl<CityDao, CityEntity> implements CityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CityEntity> page = this.selectPage(
                new Query<CityEntity>(params).getPage(),
                new EntityWrapper<CityEntity>()
        );

        return new PageUtils(page);
    }

}
