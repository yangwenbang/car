package com.car.modules.car.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.OfflineOrganizationDao;
import com.car.modules.car.entity.OfflineOrganizationEntity;
import com.car.modules.car.service.OfflineOrganizationService;


@Service("offlineOrganizationService")
public class OfflineOrganizationServiceImpl extends ServiceImpl<OfflineOrganizationDao, OfflineOrganizationEntity> implements OfflineOrganizationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OfflineOrganizationEntity> page = this.selectPage(
                new Query<OfflineOrganizationEntity>(params).getPage(),
                new EntityWrapper<OfflineOrganizationEntity>()
        );

        return new PageUtils(page);
    }

}
