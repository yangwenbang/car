package com.car.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.car.service.CommodityService;
import com.car.utils.Result;
import com.car.vo.CommodityVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
	@GetMapping("/getCommoditysByCategory/{commodityCategoryId}")
	@ApiOperation("根据分类得到商品接口")
	public Result<Page<CommodityVO>> getCommoditysByCategoryId(@PathVariable(value = "commodityCategoryId") String commodityCategoryId){
		Page<CommodityVO> page= new Page<>(0,2);
		Page<CommodityVO> commodityList = commodityService.queryCommoditysByCategoryId(page,commodityCategoryId);
		return new Result<>(0, "success",commodityList);
	}
    
}
