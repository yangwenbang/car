package com.car.modules.car.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.OfflineCustomerDao;
import com.car.modules.car.entity.OfflineCustomerEntity;
import com.car.modules.car.service.OfflineCustomerService;


@Service("offlineCustomerService")
public class OfflineCustomerServiceImpl extends ServiceImpl<OfflineCustomerDao, OfflineCustomerEntity> implements OfflineCustomerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OfflineCustomerEntity> page = this.selectPage(
                new Query<OfflineCustomerEntity>(params).getPage(),
                new EntityWrapper<OfflineCustomerEntity>()
        );

        return new PageUtils(page);
    }

}
