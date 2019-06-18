package com.car.service.impl;

import com.car.dao.PublishPostDao;
import com.car.entity.PublishPost;
import com.car.exception.DAOException;
import com.car.form.PublishPostForm;
import com.car.service.PublishPostService;
import com.car.vo.PublishPostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service("publishPostService")
public class PublishPostServiceImpl implements PublishPostService {

    @Autowired
    private PublishPostDao publishPostDao;

    @Transactional(rollbackFor = Exception.class)
    public PublishPost insertPublishPost(PublishPostForm publishPost) throws DAOException {
        PublishPost publishPostEntity = new PublishPost();
        publishPostEntity.setPublishAddress(publishPost.getPublishAddress());
        publishPostEntity.setPublishPicture(publishPost.getPublishPicture());
        publishPostEntity.setPublishContent(publishPost.getPublishContent());
        publishPostEntity.setPublishTitle(publishPost.getPublishTitle());
        publishPostEntity.setPublishUserId(publishPost.getPublishUserId());
        publishPostEntity.setPublishUserPicture(publishPost.getPublishUserPicture());
        publishPostEntity.setPublishUserName(publishPost.getPublishUserName());
        publishPostEntity.setPublishTime(new Date());
        publishPostEntity.setUpdateTime(new Date());
        publishPostDao.insertPublishPost(publishPostEntity);
        return publishPostEntity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePublishPostById(Long publishPostId) throws DAOException {
        publishPostDao.deletePublishPostById(publishPostId);
    }

    @Override
    public List<PublishPostVO> queryUserPublishPostsByUserId(Long userId) throws DAOException {
        return publishPostDao.queryUserPublishPostsByUserId(userId);
    }
}
