package com.car.controller;


import java.util.Date;

import com.car.entity.Commodity;
import com.car.entity.PublishPost;
import com.car.form.CommodityForm;
import com.car.form.PublishPostForm;
import com.car.service.CommodityService;
import com.car.service.PublishPostService;
import com.car.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.car.exception.DAOException;

import io.swagger.annotations.Api;

/**
 * 发布接口
 *
 * @author wind
 */
@RestController
@RequestMapping("/api/publish")
@Api(tags="发布接口")
public class ApiPublishController {
	private static final Logger log = LoggerFactory.getLogger(ApiPublishController.class);

	@Autowired
	private CommodityService commodityService;
	@Autowired
	private PublishPostService publishPostService;
	/**
	 * 保存商品
	 */
	@PostMapping("/saveCommodity")
	@ApiOperation("发布商品接口")
	public Result<String> saveCommodity(@ModelAttribute CommodityForm commodity) throws DAOException {
		if(commodity.getCommodityName() == null || commodity.getCommodityName().isEmpty()){
//			throw new DAOException("商品名称为空");
			return new Result<>(500, "商品名称为空");
		}
		if(commodity.getCommodityCategoryId() == null){
//			throw new DAOException("商品分类不能为空");
			return new Result<>(500, "商品分类不能为空");
		}
		Commodity commodityEntity = commodityService.insertCommodity(commodity);
		return new Result<>(0, "success");
	}

	/**
	 * 发布帖子
	 */
	@PostMapping("/savePublishPost")
	@ApiOperation("发布帖子接口")
	public Result<String> save(@ModelAttribute PublishPostForm publishPost) throws DAOException {
		if(publishPost.getPublishTitle() == null || publishPost.getPublishTitle().isEmpty()){
			throw new DAOException("帖子标题为空");
		}
		if(publishPost.getPublishContent() == null || publishPost.getPublishContent().isEmpty()){
			throw new DAOException("帖子内容为空");
		}
		if(publishPost.getPublishUserId() == null){
			throw new DAOException("帖子用户为空");
		}
		PublishPost publishPostEntity = publishPostService.insertPublishPost(publishPost);
		return new Result<>(0, "success");
	}
    
   
    
}
