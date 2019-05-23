package com.car.controller;


import static com.car.ApiConstants.DATA;

import java.util.List;

import com.car.service.CommodityService;
import com.car.utils.Result;
import com.car.vo.CommodityVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.car.annotation.Login;
import com.car.common.utils.R;
import com.car.dto.HomePageInfoDTO;
import com.car.exception.DAOException;
import com.car.service.AdvertisementService;
import com.car.vo.AdvertisementVO;

import io.swagger.annotations.Api;

/**
 * 购物接口
 *
 * @author wind
 */
@RestController
@RequestMapping("/api/buy")
@Api(tags="购物接口")
public class ApiBuyController {
	private static final Logger log = LoggerFactory.getLogger(ApiBuyController.class);

	@Autowired
	private CommodityService commodityService;
	@GetMapping("/getCommodityByCategory/{commodityCategoryId}")
	@ApiOperation("根据分类得到商品接口")
	public Result<List<CommodityVO>> getCommodityByCategoryId(@PathVariable String commodityCategoryId){
		List<CommodityVO> commodityList = commodityService.listCommodityByCategoryId(commodityCategoryId);
		return new Result<>(0, "success",commodityList);
	}
    
   
    
}
