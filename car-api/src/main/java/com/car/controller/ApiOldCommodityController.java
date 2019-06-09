package com.car.controller;


import java.util.ArrayList;
import java.util.List;

import com.car.annotation.Login;
import com.car.form.CommodityQuestionFrom;
import com.car.service.CommodityQuestionService;
import com.car.dto.CommodityQuestionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public Result<String> saveCommodity(@ModelAttribute OldCommodityForm oldCommodity) {
		if(oldCommodity.getCommodityName() == null || oldCommodity.getCommodityName().isEmpty()){
			return new Result<>(500, "商品名称为空");
		}
		if(oldCommodity.getCommodityCategoryId() == null){
			return new Result<>(500, "商品分类不能为空");
		}
		try {
			commodityService.insertCommodity(oldCommodity);
		} catch (DAOException e) {
			log.error("insert oldCommodity occur errors .", e);
			return new Result<>(500);
		}
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
		publishPostService.insertPublishPost(publishPost);
		return new Result<>(ZERO, SUCCESS);
	}

	@GetMapping("/getCommoditysByCategorys")
	@ApiOperation("获取二手商品")
	public Result<List<CommodityVO>> getCommoditysByCategoryId(@ApiParam(value = "商品分类ID")@RequestParam("commodityCategoryId") long commodityCategoryId,
			@ApiParam(value = "分页ID(从0开始)")@RequestParam("pageId") int pageId) {
		List<CommodityVO> commodityList = new ArrayList<>();
		try {
			commodityList = commodityService.queryCommoditysByCategoryId(commodityCategoryId, pageId);
		} catch (DAOException e) {
			log.error("get CommodityCategoryVO occur errors .", e);
			return new Result<>(500);
		}
		return new Result<>(0, SUCCESS,commodityList);
	}

	@Login
	@GetMapping("/getCommodityQuestionsByTypeId")
	@ApiOperation("获取问答接口")
	public Result<List<CommodityQuestionDTO>> getCommodityQuestionsByTypeId(@ApiParam(value = "问题类型ID(商品ID/帖子ID)") @RequestParam("questionTypeId") long questionTypeId,
		@ApiParam(value = "提问类型(0商品/1帖子)") @RequestParam("questionType") Integer questionType) {
		List<CommodityQuestionDTO> commodityQuestionList = null;
		try {
			commodityQuestionList = commodityQuestionService.queryCommodityQuestionsByTypeId(questionTypeId,questionType);
		} catch (DAOException e) {
			log.error("get CommodityQuestionDTO occur errors .", e);
			return new Result<>(500);
		}
		return new Result<>(0, SUCCESS,commodityQuestionList);
	}

	/**
	 * 发布商品问答接口
	 * 仅做了商品回复权限校验
	 */
	@Login
	@PostMapping("/saveCommodityQuestion")
	@ApiOperation("发布商品问答接口")
	public Result<String> saveCommodityQuestion(@ModelAttribute CommodityQuestionFrom commodityQuestionFrom ) throws DAOException {
		Long userId;
		if (commodityQuestionFrom.getReplayStatus().equals(1)){
			if (commodityQuestionFrom.getQuestionType() == 0) {
				userId = commodityQuestionService.getUserIdByCommodityId(commodityQuestionFrom.getQuestionTypeId());
			} else if (commodityQuestionFrom.getQuestionType() == 1) {
				userId = commodityQuestionService.getUserIdByPublishPostId(commodityQuestionFrom.getQuestionTypeId());
			} else {
				return new Result<>(500,"提问类型不符合规范");
			}
			if (userId == null || !userId.equals(commodityQuestionFrom.getUserId())) {
				return new Result<>(500,"你没有回复的权限");
			}
		}
		try {
			commodityQuestionService.insertCommodityQuestion(commodityQuestionFrom);
		} catch (DAOException e) {
			log.error("get CommodityQuestionDTO occur errors .", e);
			return new Result<>(500,e.getMessage());
		}
		return new Result<>(ZERO, SUCCESS);
	}

	@Login
	@DeleteMapping("/removeCommodityById")
	@ApiOperation("通过id删除商品")
	public Result<String> removeCommodityById(@ApiParam(value = "商品id") Long commodityId,
		@ApiParam(value = "发布商品的用户id") Long userId) throws DAOException {
		Long dbUserId = commodityQuestionService.getUserIdByCommodityId(commodityId);
		if (dbUserId == null || !dbUserId.equals(userId)){
			return new Result(500,"你没有删除权限");
		}
		commodityService.deleteCommodityById(commodityId);
		return new Result<>(ZERO, SUCCESS);
	}

	//todo 还没写完
	@Login
	@PutMapping("/updateCommodityById")
	@ApiOperation("通过id更新商品")
	public Result<String> updateCommodityById(Long commodityId, Long userId) throws DAOException {
		Long dbUserId = commodityQuestionService.getUserIdByCommodityId(commodityId);
		if (dbUserId == null || !dbUserId.equals(userId)){
			return new Result("你没有修改权限");
		}
		commodityService.updateCommodityById(commodityId);
		return new Result<>(ZERO, SUCCESS);
	}

	@Login
	@DeleteMapping("/removePublishPostById")
	@ApiOperation("通过id删除帖子")
	public Result<String> removePublishPostById(@ApiParam(value = "帖子id") Long publishPostId,
		@ApiParam(value = "发布帖子用户id") Long userId) throws DAOException {
		Long dbUserId = commodityQuestionService.getUserIdByPublishPostId(publishPostId);
		if (dbUserId == null || !dbUserId.equals(userId)){
			return new Result(500,"你没有删除权限");
		}
		publishPostService.deletePublishPostById(publishPostId);
		return new Result<>(ZERO, SUCCESS);
	}
}
