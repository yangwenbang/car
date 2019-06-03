package com.car.service.impl;

import com.car.dao.PublishPostDao;
import com.car.entity.PublishPost;
import com.car.form.PublishPostForm;
import com.car.service.PublishPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service("publishPostService")
public class PublishPostServiceImpl implements PublishPostService {

    private static final Integer APPROVE_STATUS = 1;

    @Autowired
    private PublishPostDao publishPostDao;

    @Transactional(rollbackFor = Exception.class)
    public PublishPost insertPublishPost(PublishPostForm publishPost) {
        PublishPost publishPostEntity = new PublishPost();
        publishPostEntity.setPublishAddress(publishPost.getPublishAddress());
        publishPostEntity.setPublishPicture(publishPost.getPublishPicture());
        publishPostEntity.setPublishContent(publishPost.getPublishContent());
        publishPostEntity.setPublishTitle(publishPost.getPublishTitle());
        publishPostEntity.setPublishUserId(publishPost.getPublishUserId());
        publishPostEntity.setPublishTime(new Date());
        publishPostEntity.setUpdateTime(new Date());
        publishPostEntity.setApproveStatus(APPROVE_STATUS);
        publishPostDao.insertPublishPost(publishPostEntity);
        return publishPostEntity;
    }
}
