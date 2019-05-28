package com.car.controller;


import java.util.ArrayList;
import java.util.List;

import com.car.annotation.Login;
import com.car.form.CommodityQuestionFrom;
import com.car.service.CommodityQuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.entity.OldCommodity;
import com.car.entity.PublishPost;
import com.car.exception.DAOException;
import com.car.form.OldCommodityForm;
import com.car.form.PublishPostForm;
import com.car.service.CommodityCategoryService;
import com.car.service.CommodityService;
import com.car.service.PublishPostService;
import com.car.utils.Result;
import com.car.vo.CommodityCategoryVO;
import com.car.vo.CommodityVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 发布接口
 *
 * @author wind
 */
@RestController
@RequestMapping("/api/oldCommodity")
@Api(tags="二手商品接口")
public class ApiOldCommodityController {
	private static final Logger log = LoggerFactory.getLogger(ApiOldCommodityController.class);
	
	private static final int ZERO = 0;
	private static final String SUCCESS = "success";

	@Autowired
	private CommodityService commodityService;
	@Autowired
	private CommodityCategoryService commodityCategoryService;
	@Autowired
	private PublishPostService publishPostService;
	@Autowired
	private CommodityQuestionService commodityQuestionService;
	/**
	 * 保存商品
	 */
	@Login
	@PostMapping("/publishCommodity")
	@ApiOperation("发布商品")
	public Result<String> saveCommodity(@ModelAttribute OldCommodityForm oldCommodity) throws DAOException {
		if(oldCommodity.getCommodityName() == null || oldCommodity.getCommodityName().isEmpty()){
			return new Result<>(500, "商品名称为空");
		}
		if(oldCommodity.getCommodityCategoryId() == null){
			return new Result<>(500, "商品分类不能为空");
		}
		OldCommodity oldCommodityEntity = commodityService.insertCommodity(oldCommodity);
		return new Result<>(ZERO, SUCCESS);
	}

	@GetMapping("/getCommodityCategorys")
	@ApiOperation("获取商品分类接口")
	public Result<List<CommodityCategoryVO>> getCommodityCategory(){
		List<CommodityCategoryVO> commodityCategoryList = new ArrayList<>();
		try {
			commodityCategoryList = commodityCategoryService.queryCommodityCategorys();
		} catch (DAOException e) {
			log.error("get CommodityCategoryVO occur errors .", e);
			return new Result<>(500);
		}
		return new Result<>(ZERO, SUCCESS,commodityCategoryList);
	}

	/**
	 * 发布帖子
	 */
	@Login
	@PostMapping("/savePublishPost")
	@ApiOperation("发布帖子接口")
	public Result<String> savePublishPost(@ModelAttribute PublishPostForm publishPost) throws DAOException {
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
		return new Result<>(ZERO, SUCCESS);
	}
    
	@GetMapping("/getCommoditysByCategorys")
	@ApiOperation("获取二手商品")
	public Result<List<CommodityVO>> getCommoditysByCategoryId(@ApiParam(value = "商品分类ID")@RequestParam("commodityCategoryId") long commodityCategoryId,
			@ApiParam(value = "分页ID(从0开始)")@RequestParam("pageId") int pageId){
		List<CommodityVO> commodityList = new ArrayList<>();
		try {
			commodityList = commodityService.queryCommoditysByCategoryId(commodityCategoryId, pageId);
		} catch (DAOException e) {
			log.error("get CommodityCategoryVO occur errors .", e);
			return new Result<>(500);
		}
		return new Result<>(0, SUCCESS,commodityList);
	}

	@GetMapping("/getCommodityQuestions")
	@ApiOperation("获取问答接口")
	public Result getCommodityQuestions(){
		//commodityQuestionService.queryCommodityQuestions();

		return new Result<>(0, SUCCESS);
	}

	/**
	 * 发布商品问答接口
	 */
	@Login
	@PostMapping("/saveCommodityQuestion")
	@ApiOperation("发布商品问答接口")
	public Result<String> saveCommodityQuestion(@ModelAttribute CommodityQuestionFrom commodityQuestionFrom ) throws DAOException {
		commodityQuestionService.insertCommodityQuestion(commodityQuestionFrom);
		return new Result<>(ZERO, SUCCESS);
	}

   
    
}
