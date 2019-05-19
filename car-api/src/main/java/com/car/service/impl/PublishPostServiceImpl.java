package com.car.service.impl;

import com.car.dao.PublishPostDao;
import com.car.entity.PublishPostEntity;
import com.car.service.PublishPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("publishPostService")
public class PublishPostServiceImpl implements PublishPostService {
    @Autowired
    private PublishPostDao publishPostDao;

    @Override
    public void insert(PublishPostEntity publishPostEntity) {
        publishPostDao.insert(publishPostEntity);
    }
}
