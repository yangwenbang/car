package com.car.controller;


import static com.car.ApiConstants.DATA;

import java.util.List;

import com.car.dto.MainPageInfoDTO;
import com.car.service.CommodityQuestionService;
import com.car.utils.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.annotation.Login;
import com.car.common.utils.R;
import com.car.dto.HomePageInfoDTO;
import com.car.exception.DAOException;
import com.car.service.AdvertisementService;
import com.car.vo.AdvertisementVO;

import io.swagger.annotations.Api;

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
    private AdvertisementService advertisementService;
	@Autowired
	private CommodityQuestionService commodityQuestionService;


    @Login
    @GetMapping("homePageInfos")
	public R getHomePageInfo(@RequestParam("userId") long userId,
			@RequestParam("projectId") long projectId, 
			@RequestParam("categoryId") long categoryId) throws DAOException {
    	
    	if (userId == 0 || projectId == 0 || categoryId == 0) {
    		throw new DAOException("project or categoryId is null");
    	}
    	
    	HomePageInfoDTO pageInfo = null;
    	try {
    	// banner
    	List<AdvertisementVO> advertisements = advertisementService.getAdvertisementsByProject(projectId);
    	
    	} catch (DAOException e) {
    		log.error("get HomePageInfoDTO occur errors . ", e);
    		R.error();
    	}
    	
		return R.ok().put(DATA, pageInfo);
    }

	@Login
	@GetMapping("/getMainPageCommodityQuestions")
	@ApiOperation("获取主页帖子信息")
	public Result<List<MainPageInfoDTO>> getPageInfoCommodityQuestions(@ApiParam(value = "分页ID(从0开始)")@RequestParam("pageId") int pageId) {
		List<MainPageInfoDTO> mainPageList = null;
		try {
			mainPageList = commodityQuestionService.queryPageInfoCommodityQuestions(pageId);
		} catch (DAOException e) {
			log.error("get mainPageList occur errors . ", e);
			return new Result<>(500,e.getMessage());
		}
		return new Result<>(ZERO,SUCCESS,mainPageList);
	}
    
}
