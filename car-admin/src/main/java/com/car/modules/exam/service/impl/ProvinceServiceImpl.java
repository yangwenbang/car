package com.car.modules.car.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.ProvinceDao;
import com.car.modules.car.entity.ProvinceEntity;
import com.car.modules.car.service.ProvinceService;


@Service("provinceService")
public class ProvinceServiceImpl extends ServiceImpl<ProvinceDao, ProvinceEntity> implements ProvinceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ProvinceEntity> page = this.selectPage(
                new Query<ProvinceEntity>(params).getPage(),
                new EntityWrapper<ProvinceEntity>()
        );

        return new PageUtils(page);
    }

}
