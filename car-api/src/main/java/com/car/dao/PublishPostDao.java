package com.car.dao;

import com.car.entity.PublishPost;
import com.car.exception.DAOException;
import com.car.vo.PublishPostVO;

import java.util.List;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-19 23:07:55
 */
public interface PublishPostDao {

    void insertPublishPost(PublishPost publishPostEntity) throws DAOException;

    void deletePublishPostById(Long publishPostId) throws DAOException;

    List<PublishPostVO> queryUserPublishPostsByUserId(Long userId) throws DAOException;
}
