package com.car.modules.car.service.impl;

import com.car.modules.car.entity.ExerciseContentEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.MsgTypeDao;
import com.car.modules.car.entity.MsgTypeEntity;
import com.car.modules.car.service.MsgTypeService;


@Service("msgTypeService")
public class MsgTypeServiceImpl extends ServiceImpl<MsgTypeDao, MsgTypeEntity> implements MsgTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MsgTypeEntity> page = this.selectPage(
                new Query<MsgTypeEntity>(params).getPage(),
                new EntityWrapper<MsgTypeEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryWithProject(Map<String, Object> params) {
        Page<MsgTypeEntity> page = new Query<MsgTypeEntity>(params).getPage();
        page = page.setRecords(this.baseMapper.queryWithProject(page));
        return new PageUtils(page);
    }

}
