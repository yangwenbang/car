package com.car.controller;


import static com.car.ApiConstants.DATA;
import static com.car.ApiConstants.ZERO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.car.form.*;
import com.car.service.*;
import com.car.utils.Result;
import com.car.vo.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.car.annotation.Login;
import com.car.common.utils.R;
import com.car.dto.CommodityQuestionDTO;
import com.car.dto.ProvinceAndCityNameDTO;
import com.car.entity.PayRecord;
import com.car.exception.DAOException;
import com.car.pay.alipay.AlipayUtils;
import com.car.pay.service.PayService;
import com.car.pay.service.impl.AliPayServiceImpl;
import com.car.pay.service.impl.WeChatPayServiceImpl;
import com.car.pay.wxpay.WeChatPayUtils;
import com.car.utils.StringUtil;

/**
 * 个人接口
 *
 * @author wind
 */
@RestController
@RequestMapping("/api/personal")
@Api(tags="个人接口")
public class ApiPersonalController {
	private static final Logger log = LoggerFactory.getLogger(ApiPersonalController.class);
	private static final String SUCCESS = "success";


    @Autowired
    private AdvertisementService advertisementService;
    @Autowired
    private CityService cityService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private EquipmentManagerService equipmentManagerService;

    @Autowired
	private UserFeedbackService userFeedbackService;
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private PublishPostService publishPostService;
	@Autowired
	private SysInfoService sysInfoService;
    
    @Login
    @GetMapping("userAddress")
    @ApiOperation("获取用户地址接口")
    public Result<List<UserAddressVO>> getUserAddress(@ApiParam(value = "用户ID")@RequestParam("userId") long userId) throws DAOException {
    	List<UserAddressVO> userAddress = new ArrayList<>();
		try {
			
			userAddress = userAddressService.getUserAddressByUser(userId);
				
		} catch (DAOException e) {
			log.error("get userAddress occur error ", e);
			return new Result<>(500, e.getMessage());
		}
		
        return new Result<>(ZERO, SUCCESS, userAddress);
    }
    
    @Login
    @PostMapping("saveUserAddress")
    @ApiOperation("保存用户地址接口")
    public Result<String> saveUserAddress(@ModelAttribute UserAddressForm userAddressForm) throws DAOException {
    	
    	if (userAddressForm == null) {
    		throw new DAOException("userAddressForm is null");
    	}
    	
    	long userId = userAddressForm.getUserId();
    	if (userId == 0) {
    		throw new DAOException("usreId is null");
    	}

		try {
			
			userAddressService.saveUserAddress(userAddressForm);		
			
		} catch (DAOException e) {
			log.error("save userAddress occur error ", e);
			return new Result<>(500, e.getMessage());
		}

		return new Result<>(ZERO, SUCCESS);
    }
    
    @Login
    @PostMapping("updateUserAddress")
    public R updateUserAddress(@ModelAttribute UserAddressForm userAddressForm) throws DAOException {
    	
    	if (userAddressForm == null) {
    		throw new DAOException("userAddressForm is null");
    	}
    	
    	long userId = userAddressForm.getUserId();
    	long userAddressId = userAddressForm.getUserAddressId();
    	if (userId == 0 || userAddressId == 0) {
    		throw new DAOException("usreId or userAddressId is null");
    	}

		try {
			
			userAddressService.updateUserAddress(userAddressForm);		
			
		} catch (DAOException e) {
			log.error("update userAddress occur error ", e);
			return R.error();
		}

        return R.ok();
    }
    
    @Login
    @PostMapping("deleteUserAddress")
    public R deleteUserAddress(@ModelAttribute long userAddressId) throws DAOException {
    	
    	if (userAddressId == 0) {
    		throw new DAOException("userAddressId is null");
    	}
    	
		try {
			
			userAddressService.deleteUserAddress(userAddressId);	
			
		} catch (DAOException e) {
			log.error("delete userAddress occur error ", e);
			return R.error();
		}

        return R.ok();
    }
    
    
    
    @GetMapping("equipmentInfo")
    public R getEquipmentInfo(@RequestParam("equipmentType") int equipmentType) throws DAOException {
    	EquipmentManagerVO EquipmentManager = null;
		try {
			
			EquipmentManager = equipmentManagerService.getLastEquipmentManagerByType(equipmentType);
				
		} catch (DAOException e) {
			log.error("get EquipmentManager occur error ", e);
			return R.error();
		}
		
        return R.ok().put(DATA, EquipmentManager);
    }
    
	@Login
	@PostMapping("/saveUserFeedback")
	@ApiOperation("用户反馈接口")
	public Result<String> saveUserFeedback(@ModelAttribute UserFeedbackFrom userFeedbackFrom) {
		try {
			userFeedbackService.insertUserFeedback(userFeedbackFrom);
		} catch (DAOException e) {
			log.error("insert Feedback occur errors .", e);
			return new Result<>(500);
		}
		return new Result<>(ZERO, SUCCESS);
	}

	@Login
	@GetMapping("/getUserOldCommoditys")
	@ApiOperation("用户旧商品接口")
	public Result<List<CommodityVO>> getUserOldCommoditysByUserId(@ApiParam(value = "用户ID")@RequestParam("userId") Long userId) {
		List<CommodityVO> commodityList = null;
    	try {
			commodityList = commodityService.queryUserOldCommoditysByUserId(userId);
		} catch (DAOException e) {
			log.error("get UserOldCommoditys occur errors .", e);
			return new Result<>(500);
		}
		return new Result<>(ZERO, SUCCESS,commodityList);
	}

	@Login
	@GetMapping("/getUserPublishPosts")
	@ApiOperation("用户帖子接口")
	public Result<List<PublishPostVO>> getUserPublishPostsByUserId(@ApiParam(value = "用户ID")@RequestParam("userId") Long userId) {
		List<PublishPostVO> publishPostList = null;
    	try {
			publishPostList = publishPostService.queryUserPublishPostsByUserId(userId);
		} catch (DAOException e) {
			log.error("get UserPublishPosts occur errors .", e);
			return new Result<>(500);
		}
		return new Result<>(ZERO, SUCCESS,publishPostList);
	}

	@Login
	@GetMapping("/getUserInfos")
	@ApiOperation("用户消息接口")
	public Result<List<SysInfoVO>> getUserInfosByUserId(@ApiParam(value = "用户ID")@RequestParam("userId") Long userId) {
		List<SysInfoVO> sysInfoList = null;
		try {
			sysInfoList = sysInfoService.queryUserInfosByUserId(userId);
		} catch (DAOException e) {
			log.error("get UserPublishPosts occur errors .", e);
			return new Result<>(500);
		}
		return new Result<>(ZERO, SUCCESS,sysInfoList);
	}

	@Login
	@DeleteMapping("/deleteUserInfo")
	@ApiOperation("删除消息接口")
	public Result<List<SysInfoVO>> removeUserInfoById(@ApiParam(value = "消息ID") Long sysInfoId) {
		try {
			sysInfoService.deleteUserInfoById(sysInfoId);
		} catch (DAOException e) {
			log.error("delete UserInfo occur errors .", e);
			return new Result<>(500);
		}
		return new Result<>(ZERO, SUCCESS);
	}
}
