package com.car.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.annotation.Login;
import com.car.dto.CommodityQuestionDTO;
import com.car.dto.MainPageInfoDTO;
import com.car.exception.DAOException;
import com.car.service.CommodityQuestionService;
import com.car.utils.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 主页接口
 *
 * @author wind
 */
@RestController
@RequestMapping("/api/main")
@Api(tags="主页接口")
public class ApiMainController {
	private static final Logger log = LoggerFactory.getLogger(ApiMainController.class);
	private static final int ZERO = 0;
	private static final String SUCCESS = "success";

	@Autowired
	private CommodityQuestionService commodityQuestionService;

	@Login
	@GetMapping("/getMainPageInfo")
	@ApiOperation("获取主页帖子信息")
	public Result<List<MainPageInfoDTO>> getPageInfoCommodityQuestions(@ApiParam(value = "分页ID(从0开始)", required = true)@RequestParam("pageId") int pageId) {
		List<MainPageInfoDTO> mainPageList = null;
		try {
			mainPageList = commodityQuestionService.queryPageInfoCommodityQuestions(pageId);
		} catch (DAOException e) {
			log.error("get mainPageList occur errors . ", e);
			return new Result<>(500, e.getMessage());
		}
		return new Result<>(ZERO, SUCCESS, mainPageList);
	}
	
	@Login
	@GetMapping("/getPublishPostQuestions")
	@ApiOperation("获取帖子评论接口")
	public Result<List<CommodityQuestionDTO>> getMainPublishQuestionsById(@ApiParam(value = "发布帖子ID") @RequestParam("publishPostId") long publishPostId) {
	   List<CommodityQuestionDTO> commodityQuestionList = null;
	   try {
	      commodityQuestionList = commodityQuestionService.queryCommodityQuestionsByTypeId(publishPostId, 1);
	   } catch (DAOException e) {
	      log.error("get CommodityQuestionDTO occur errors .", e);
	      return new Result<>(500, e.getMessage());
	   }
	   return new Result<>(0, SUCCESS,commodityQuestionList);
	}
    
}
