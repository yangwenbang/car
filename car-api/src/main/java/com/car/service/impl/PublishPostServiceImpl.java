package com.car.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car.dao.PublishPostDao;
import com.car.dao.UserDao;
import com.car.entity.PublishPost;
import com.car.exception.DAOException;
import com.car.form.PublishPostForm;
import com.car.service.PublishPostService;
import com.car.vo.PublishPostVO;
import com.car.vo.UserVO;


@Service("publishPostService")
public class PublishPostServiceImpl implements PublishPostService {

    @Autowired
    private PublishPostDao publishPostDao;
    @Autowired
    private UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    public PublishPost insertPublishPost(PublishPostForm publishPost) throws DAOException {
    	
    	UserVO user = userDao.findById(publishPost.getPublishUserId());
    	
        PublishPost publishPostEntity = new PublishPost();
        publishPostEntity.setPublishAddress(publishPost.getPublishAddress());
        publishPostEntity.setPublishPicture(publishPost.getPublishPicture());
        publishPostEntity.setPublishContent(publishPost.getPublishContent());
        publishPostEntity.setPublishTitle(publishPost.getPublishTitle());
        publishPostEntity.setPublishUserId(publishPost.getPublishUserId());
        publishPostEntity.setPublishUserPicture(user.getUserPicture());
        publishPostEntity.setPublishUserName(user.getUserName());
        publishPostEntity.setDetailAddress(publishPost.getDetailAddress());
        publishPostEntity.setLongitude(publishPost.getLongitude());
        publishPostEntity.setLatitude(publishPost.getLatitude());
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
