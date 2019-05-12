package com.car.modules.car.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.CommodityDao;
import com.car.modules.car.entity.CommodityEntity;
import com.car.modules.car.service.CommodityService;


@Service("commodityService")
public class CommodityServiceImpl extends ServiceImpl<CommodityDao, CommodityEntity> implements CommodityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CommodityEntity> page = this.selectPage(
                new Query<CommodityEntity>(params).getPage(),
                new EntityWrapper<CommodityEntity>()
        );

        return new PageUtils(page);
    }

}
