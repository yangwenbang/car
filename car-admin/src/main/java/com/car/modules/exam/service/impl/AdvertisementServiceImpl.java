package com.car.modules.car.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.AdvertisementDao;
import com.car.modules.car.entity.AdvertisementEntity;
import com.car.modules.car.service.AdvertisementService;


@Service("advertisementService")
public class AdvertisementServiceImpl extends ServiceImpl<AdvertisementDao, AdvertisementEntity> implements AdvertisementService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AdvertisementEntity> page = this.selectPage(
                new Query<AdvertisementEntity>(params).getPage(),
                new EntityWrapper<AdvertisementEntity>()
        );

        return new PageUtils(page);
    }

}
