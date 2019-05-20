package com.car.service;

import com.car.entity.PublishPost;
import com.car.form.PublishPostForm;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-19 23:07:55
 */
public interface PublishPostService{

    PublishPost insertPublishPost(PublishPostForm publishPostEntity);
}

