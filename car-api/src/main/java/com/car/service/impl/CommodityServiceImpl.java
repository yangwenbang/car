package com.car.service.impl;

import com.car.dao.CommodityDao;
import com.car.entity.CommodityEntity;
import com.car.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;

    @Override
    public void insert(CommodityEntity commodity) {
        commodityDao.insert(commodity);
    }
}
