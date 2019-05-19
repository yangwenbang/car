package com.car.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.car.entity.PublishPostEntity;
import com.car.exception.DAOException;
import com.car.form.PublishPostForm;
import com.car.service.PublishPostService;
import com.car.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-19 23:07:55
 */
@RestController
@RequestMapping("/car/publishpost")
public class PublishPostController {
    @Autowired
    private PublishPostService publishPostService;

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@ModelAttribute PublishPostForm publishPost) throws DAOException {
        if(publishPost.getPublishTitle() == null || publishPost.getPublishTitle().isEmpty()){
            throw new DAOException("帖子标题为空");
        }
        if(publishPost.getPublishContent() == null || publishPost.getPublishContent().isEmpty()){
            throw new DAOException("帖子内容为空");
        }
        if(publishPost.getPublishUserId() == null){
            throw new DAOException("帖子用户为空");
        }
        PublishPostEntity publishPostEntity = new PublishPostEntity();
        publishPostEntity.setPublishAddress(publishPost.getPublishAddress());
        publishPostEntity.setPublishPicture(publishPost.getPublishPicture());
        publishPostEntity.setPublishContent(publishPost.getPublishContent());
        publishPostEntity.setPublishTitle(publishPost.getPublishTitle());
        publishPostEntity.setPublishTime(new Date());
        publishPostEntity.setUpdateTime(new Date());
        publishPostService.insert(publishPostEntity);
        return new Result(publishPostEntity);
    }

}
