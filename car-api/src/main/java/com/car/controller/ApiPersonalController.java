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

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.annotation.Login;
import com.car.common.utils.R;
import com.car.dto.ProvinceAndCityNameDTO;
import com.car.entity.PayRecord;
import com.car.exception.DAOException;
import com.car.form.PayForm;
import com.car.form.UserAddressForm;
import com.car.form.UserDetailForm;
import com.car.form.VipContentForm;
import com.car.pay.alipay.AlipayUtils;
import com.car.pay.service.PayService;
import com.car.pay.service.impl.AliPayServiceImpl;
import com.car.pay.service.impl.WeChatPayServiceImpl;
import com.car.pay.wxpay.WeChatPayUtils;
import com.car.service.AdvertisementService;
import com.car.service.CityService;
import com.car.service.CourseService;
import com.car.service.EquipmentManagerService;
import com.car.service.NewMsgService;
import com.car.service.OfflineOrganizationService;
import com.car.service.PayRecordService;
import com.car.service.ProvinceService;
import com.car.service.SysDeptService;
import com.car.service.UserAddressService;
import com.car.service.UserDetailService;
import com.car.service.UserProjectService;
import com.car.service.UserService;
import com.car.service.VipContentService;
import com.car.service.VipRecordService;
import com.car.utils.StringUtil;
import com.car.vo.AboutCompanyVO;
import com.car.vo.CityVO;
import com.car.vo.EquipmentManagerVO;
import com.car.vo.OfflineOrganizationVO;
import com.car.vo.ProvinceVO;
import com.car.vo.SysDeptVO;
import com.car.vo.UserAddressVO;
import com.car.vo.UserDetailVO;
import com.car.vo.UserVO;
import com.car.vo.VipContentVO;

/**
 * 个人接口
 *
 * @author wind
 */
@RestController
@RequestMapping("/api/personal")
public class ApiPersonalController {
	private static final Logger log = LoggerFactory.getLogger(ApiPersonalController.class);

    @Autowired
    private AdvertisementService advertisementService;
    @Autowired
    private NewMsgService newMsgService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CityService cityService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private VipContentService vipContentService;
    @Autowired
    private UserProjectService userProjectService;
    @Autowired
    private VipRecordService vipRecordService;
    @Autowired
    private PayRecordService payRecordService;
    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private OfflineOrganizationService offlineOrganizationService;
    @Autowired
    private SysDeptService sysDeptService;
    @Autowired
    private EquipmentManagerService equipmentManagerService;
    
    @Login
    @PostMapping("saveUserDetail")
    public R login(@ModelAttribute UserDetailForm userDetailForm) throws DAOException {
    	
    	long userId = userDetailForm.getUserId();
    	String columnNames = userDetailForm.getColumnNames();
    	String columnValues = userDetailForm.getColumnValues();
    	
    	if (userId == 0) {
    		throw new DAOException("userId is null");
    	}

		try {
			UserVO userVO = userService.findById(userId);
			
			UserDetailVO detailVO = userDetailService.getUserDetailByCondition(userId);
			
			String cityName = "";
			String education = "";
			String userPic = "";
			int userType = 0;
			int buySmsRemind = 0;
			int openSmsRemind = 1;
			long cityId = 0;
			
			
			if (detailVO != null) {
				cityId = detailVO.getCityId();
				education = detailVO.getEducation();
				buySmsRemind = detailVO.getBuySmsRemind();
				openSmsRemind = detailVO.getOpenSmsRemind();
				userType = detailVO.getUserType();
				userPic = detailVO.getUserPicture();
			}
			
			String[] columnName = StringUtil.tokenize(columnNames, ";", true, true);
			String[] columnValue = StringUtil.tokenize(columnValues, ";", true, true);
			
			if (columnName.length != columnValue.length) {
				throw new DAOException("字段名和字段值不匹配！");
			}
			
			boolean isBuy = false;
			for (int i = 0; i < columnName.length; i++) {
				
				String name = columnName[i];
				String value = columnValue[i];
				
				if ("cityName".equals(name)) {
					
					CityVO cityVO = cityService.findByCityName(value);
					
					if (cityVO == null) {
						throw new DAOException("cityName : " + cityName + " 在数据库中不存在!");
					}
					
					cityId = cityVO.getCityId();
					continue;
					
				}
				
				if ("education".equals(name)) {
					education = value;
					continue;
				}
				
				if ("buySmsRemind".equals(name)) {
					buySmsRemind = Integer.valueOf(value);
					continue;
				}

				if ("openSmsRemind".equals(name)) {
					openSmsRemind = Integer.valueOf(value);
					continue;
				}
				
				if ("userType".equals(name)) {
					userType = Integer.valueOf(value);
					continue;
				}
				
				if ("userPicture".equals(name)) {
					userPic = value;
					continue;
				}
				
			}
			
			if (detailVO == null) {
				
				// 新增.
				detailVO = new UserDetailVO();
				detailVO.setUserId(userId);
				detailVO.setCityId(cityId);
				detailVO.setEducation(education);
				detailVO.setBuySmsRemind(buySmsRemind);
				detailVO.setOpenSmsRemind(openSmsRemind);
				detailVO.setUserType(userType);
				userDetailService.saveUserDetail(detailVO);
				
			} else {
				
				detailVO.setCityId(cityId);
				detailVO.setEducation(education);
				detailVO.setBuySmsRemind(buySmsRemind);
				detailVO.setOpenSmsRemind(openSmsRemind);
				detailVO.setUserType(userType);
				userDetailService.updateUserDetail(detailVO);
				
			}
		} catch (DAOException e) {
			log.error("save userDetail occur error ", e);
			return R.error();
		}

        return R.ok();
    }
    
    @Login
    @GetMapping("provinceAndCityNames")
    public R getProvinceAndCityNames() throws DAOException {
    	List<ProvinceAndCityNameDTO> provinceCityNames = new ArrayList<>();
		try {
			List<ProvinceVO> provinceVOs = provinceService.getProvinces();
			
			List<String> cityNames = null;
			ProvinceAndCityNameDTO vo = null;
			List<CityVO> citys = new ArrayList<CityVO>();
			for (ProvinceVO province : provinceVOs) {
				
				citys = cityService.getCitysByProvince(province.getProvinceId());
				
				cityNames = new ArrayList<String>();
				for (CityVO city : citys) {
					cityNames.add(city.getCityName());
				}
				
				vo = new ProvinceAndCityNameDTO(province.getProvinceName(), cityNames);
				
				provinceCityNames.add(vo);
				
				vo = null;
				
			}
		} catch (DAOException e) {
			log.error("get provinceCityNames occur error ", e);
			return R.error();
		}
		
        return R.ok().put(DATA, provinceCityNames);
    }
    
    @Login
    @GetMapping("vipContents")
    public R getVipContents(@RequestParam("projectId") long projectId) throws DAOException {
    	List<VipContentVO> vipContents = new ArrayList<>();
		try {
			
			vipContents = vipContentService.getVipContentsByProject(projectId);
				
		} catch (DAOException e) {
			log.error("get vipContents occur error ", e);
			return R.error();
		}
		
        return R.ok().put(DATA, vipContents);
    }
    
    @Login
    @PostMapping("buyVipByProject")
    public R buyVipByProject(@ModelAttribute VipContentForm vipContentForm) throws DAOException {
    	
    	if (vipContentForm == null) {
    		throw new DAOException("vipContentForm is null");
    	}
    	
    	long userId = vipContentForm.getUserId();
    	long vipContentId = vipContentForm.getVipContentId();
    	if (userId == 0 || vipContentId == 0) {
    		throw new DAOException("usreId or vipContentId is null");
    	}

    	String vipEndDate = "";
		try {
			
			vipEndDate = vipRecordService.buyVipByProject(userId, vipContentId);			
			
		} catch (DAOException e) {
			log.error("save userDetail occur error ", e);
			return R.error();
		}

        return R.ok().put(DATA, vipEndDate);
    }
    
    @Login
    @PostMapping("pay")
    public R pay(@ModelAttribute PayForm payForm,
    		HttpServletRequest request) throws Exception {
    	
    	long userId = payForm.getUserId();
    	int payType = payForm.getPayType();
    	String coin = payForm.getCoin();
    	
    	if (userId == 0) {
    		throw new DAOException("userId is null");
    	}
    	
    	String data = "";
    	try {
    		String ipAddress = getIpAddress(request);
    		String orderNo = AlipayUtils.getOrderNo();
    		if (payType == 0) { // 支付宝
    			PayService aliPayService = new AliPayServiceImpl();
    			String notifyUrl = AlipayUtils.getNotifyUrl(request);
    			data = aliPayService.createAliOrder(notifyUrl, orderNo, coin, "学币充值", ipAddress);
    			
    			// orderNo错误
    			savePayRecord(userId, payType, orderNo, coin);
    			
    			return R.ok().put(DATA, data);
    		} else if (payType == 1) { // 微信
    			PayService weChatService = new WeChatPayServiceImpl();
    			String notifyUrl = WeChatPayUtils.getNotifyUrl(request);
//    			Map<String, String> dataMap = weChatService.createWeChatOrder(notifyUrl, orderNo, coin, "", ipAddress);
    			SortedMap<String, Object> dataMap = weChatService.createWeChatOrder(notifyUrl, orderNo, coin, "学币充值", ipAddress);
    			
    			savePayRecord(userId, payType, orderNo, coin);
    			
    			return R.ok().put(DATA, dataMap);
    		}
				
		} catch (Exception e) {
			log.error("get pay occur error ", e);
			return R.error();
		}
		
        return R.ok();
    }

    @PostMapping("alipayNotify")
    public String alipayNotify(HttpServletRequest request, HttpServletResponse response) {
        try {
        	PayService aliPayService = new AliPayServiceImpl();
            return aliPayService.callBack(request, response);
        } catch (Exception e) {
            response.setHeader("Content-type", "application/xml");
            return "<xml>\n" +
                    "  <return_code><![CDATA[FAIL]]></return_code>\n" +
                    "  <return_msg><![CDATA[]]></return_msg>\n" +
                    "</xml>";
        }
    }
    
    @PostMapping("weChatNotify")
    public String weChatNotify(HttpServletRequest request, HttpServletResponse response) {
        try {
        	PayService weChatService = new WeChatPayServiceImpl();
            return weChatService.callBack(request, response);
        } catch (Exception e) {
            response.setHeader("Content-type", "application/xml");
            return "<xml>\n" +
                    "  <return_code><![CDATA[FAIL]]></return_code>\n" +
                    "  <return_msg><![CDATA[]]></return_msg>\n" +
                    "</xml>";
        }
    }
    
    @Login
    @GetMapping("userAddress")
    public R getUserAddress(@RequestParam("userId") long userId) throws DAOException {
    	List<UserAddressVO> userAddress = new ArrayList<>();
		try {
			
			userAddress = userAddressService.getUserAddressByUser(userId);
				
		} catch (DAOException e) {
			log.error("get userAddress occur error ", e);
			return R.error();
		}
		
        return R.ok().put(DATA, userAddress);
    }
    
    @Login
    @PostMapping("saveUserAddress")
    public R saveUserAddress(@ModelAttribute UserAddressForm userAddressForm) throws DAOException {
    	
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
			return R.error();
		}

        return R.ok();
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
    
    @Login
    @GetMapping("aboutCompany")
    public R getAboutCompany(String organizationCode) throws DAOException {
    	AboutCompanyVO aboutCompany = new AboutCompanyVO();
		try {
			
			if (StringUtils.isNotEmpty(organizationCode)) {
				OfflineOrganizationVO organization = offlineOrganizationService.findOfflineOrganizationByCode(organizationCode);
				
				if (organization == null) {
					return R.ok().put(DATA, aboutCompany);
				}
				
				aboutCompany.setCompanyAddress(organization.getOrganizationAddress());
				aboutCompany.setCompanyContact(organization.getContact());
				aboutCompany.setCompanyDesc(organization.getOrganizationDesc());
				aboutCompany.setCompanyName(organization.getOrganizationName());
				aboutCompany.setCompanyPhone(organization.getPhone());
				aboutCompany.setCompanyPicture(organization.getOrganizationPicture());
			} else {
				SysDeptVO sysDept = sysDeptService.findFirstSysDept();
				aboutCompany.setCompanyAddress(sysDept.getAddress());
				aboutCompany.setCompanyContact(sysDept.getContact());
				aboutCompany.setCompanyDesc(sysDept.getDescription());
				aboutCompany.setCompanyName(sysDept.getName());
				aboutCompany.setCompanyPhone(sysDept.getPhone());
				aboutCompany.setCompanyPicture(sysDept.getPicture());
			}
				
		} catch (DAOException e) {
			log.error("get vipContents occur error ", e);
			return R.error();
		}
		
        return R.ok().put(DATA, aboutCompany);
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
    
    private void savePayRecord(long userId, int payType, String orderNo, String coin)
			throws DAOException {
		// payRecord
		UserVO user = userService.findById(userId);
		PayRecord payRecord = new PayRecord();
		payRecord.setUserId(userId);
		payRecord.setUserMobile(user.getMobile());
		payRecord.setUserName(user.getUserName());
		payRecord.setCargoType(ZERO);
		payRecord.setPayOrReturn(ZERO);
		payRecord.setPayDate(new Date());
		payRecord.setCoin(new BigDecimal(coin));
		payRecord.setPayType(payType);
		payRecord.setBank("");
		payRecord.setCardNum("");
		payRecord.setPayer(user.getUserName());
		payRecord.setOrderNo(orderNo);
		payRecord.setPayStatus(ZERO);
		payRecord.setVersion(ZERO);
		payRecordService.savePayRecord(payRecord);
	}
    
    private static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
    
}
