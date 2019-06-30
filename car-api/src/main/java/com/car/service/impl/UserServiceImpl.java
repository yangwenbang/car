package com.car.service.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car.dao.CityDao;
import com.car.dao.EquipmentManagerDao;
import com.car.dao.UserDao;
import com.car.dao.UserDetailDao;
import com.car.entity.TokenEntity;
import com.car.entity.UserEntity;
import com.car.exception.DAOException;
import com.car.filter.EmojiFilter;
import com.car.form.MobileLoginForm;
import com.car.form.WeChatLoginForm;
import com.car.service.TokenService;
import com.car.service.UserService;
import com.car.utils.WeChatLoginUtils;
import com.car.vo.CityVO;
import com.car.vo.UserDetailVO;
import com.car.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private TokenService tokenService;
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserDetailDao userDetailDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	private EquipmentManagerDao equipmentManagerDao;
	
	@Transactional(rollbackFor = Exception.class)
	public UserVO login(MobileLoginForm form) throws DAOException {
		
		String mobile = form.getMobile();
		String shaPwd = StringUtils.isEmpty(form.getPassword()) ? "" : DigestUtils.sha256Hex(form.getPassword());
		int equipmentType = form.getEquipmentType();
		String equipmentModel = form.getEquipmentModel();
		String systemVersion = form.getSystemVersion();
		
		UserVO userVO = userDao.findUserByCondition(mobile, shaPwd);
		if (userVO == null) {
			userVO = userDao.findUserVOByMobile(mobile);
			if (userVO != null) { // 注销的用户.
				userDao.updateUserMobile(userVO.getUserId(), shaPwd);
			}
		}
		
		if (userVO != null) { // 登录.
//			// 用户明细.
			long userId = userVO.getUserId();
			
		} else { // 注册.
			
			// 验证码：通过redis获取验证
			//...
			
			UserEntity userEntity  = new UserEntity();
			userEntity.setMobile(mobile);
			userEntity.setPassword(shaPwd);
			userEntity.setCreateTime(new Date());
			userEntity.setUpdateTime(new Date());
			userDao.saveUser(userEntity);
			
			// userDetail
			UserDetailVO userDetail = new UserDetailVO();
			userDetail.setUserId(userEntity.getUserId());
			userDetail.setUserCode(getUserCode());
			userDetail.setEquipmentType(equipmentType);
			userDetail.setEquipmentModel(equipmentModel);
			userDetail.setSystemVersion(systemVersion);
			userDetailDao.saveUserDetail(userDetail);
			
			userVO = new UserVO();
			userVO.setUserId(userEntity.getUserId());
			userVO.setMobile(mobile);
//			userVO.setSoftVersion(softVersion);
		}
		
		//获取登录token
		TokenEntity tokenEntity = tokenService.createToken(userVO.getUserId());
		userVO.setToken(tokenEntity.getToken());
		
		return userVO;
	}

	@Override
	public UserVO findById(long userId) throws DAOException {
		return userDao.findById(userId);
	}

	@Override
	@Transactional
	public UserVO weChatLogin(WeChatLoginForm form) throws Exception {
		Map<String, Object> weChatMap = new HashMap<>();
		
		String code = form.getCode();
		String shaPwd = StringUtils.isEmpty(form.getPassword()) ? "" : DigestUtils.sha256Hex(form.getPassword());
		weChatMap = WeChatLoginUtils.getAccessToken(code);
		String openid = (String)weChatMap.get("openid");
		String accessToken = (String)weChatMap.get("accessToken");
		UserVO userVO = userDao.findUserByOpenidAndPassword(openid, shaPwd);
		
		if (StringUtils.isEmpty(openid)) {
			throw new Exception("openid is null");
		}
		
		if (userVO == null) {
			userVO = userDao.findUserByOpenid(openid);
			if (userVO != null) { // 注销的用户.
				userDao.updateUserMobile(userVO.getUserId(), shaPwd);
			}
		}
		
		if (userVO == null) {
			// 第一次微信登录
			weChatMap.putAll(WeChatLoginUtils.getWeChatUserInfo(accessToken, openid));
			
			userVO = saveWeChatLoginInfo(form, weChatMap);
		} else {
			// 用户选择的项目.
//			List<UserProjectVO> userProjects = userProjectDao.getUserProjectsByUser(userVO.getUserId());
//			if (!CollectionUtils.isEmpty(userProjects)) {
//				UserProjectVO userProject = userProjects.get(0);
//				userVO.setProjectId(userProject.getProjectId());
//				userVO.setCategoryId(userProject.getCategoryId());
//				userVO.setProjectName(userProject.getProjectName());
//				userVO.setCategoryName(userProject.getCategoryName());
//			}
			
		}
		
		
		//获取登录token
		TokenEntity tokenEntity = tokenService.createToken(userVO.getUserId());
		userVO.setToken(tokenEntity.getToken());
		
		return userVO;
	}
	
	private String getUserCode() throws DAOException {
//		int userCount = userDao.getUserCount();
		String maxUserCode = userDetailDao.getMaxUserCode();
		
		int userCount = 1;
		if (StringUtils.isNotEmpty(maxUserCode)) {
			userCount = Integer.valueOf(maxUserCode) + 1;
		}
		
		return String.format("%08d", userCount);
	}

	private UserVO saveWeChatLoginInfo(WeChatLoginForm form, Map<String, Object> weChatMap) throws DAOException {
		String userName = (String)weChatMap.get("userName");
		String cityName = (String)weChatMap.get("cityName");
		String picUrl = (String)weChatMap.get("picUrl");
//		String refreshToken = responseObj.getString("refresh_token");
		
		// sys_user 
		String shaPwd = StringUtils.isEmpty(form.getPassword()) ? "" : DigestUtils.sha256Hex(form.getPassword());
		UserEntity user = new UserEntity();
		user.setUsername(EmojiFilter.filterEmoji(userName));
		//log.info("userName  : " + userName);
		user.setStatus(1);
		user.setUserType(0);
		user.setPassword(shaPwd);
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		userDao.saveUser(user);
		
		UserDetailVO userDetail = saveUserDetail(user.getUserId(), form, weChatMap);
		
		// 组返回数据
		UserVO userVO = new UserVO();
		userVO.setUserId(user.getUserId());
		userVO.setCityName(cityName);
		userVO.setUserName(userName);
		userVO.setUserPicture(picUrl);
		
		return userVO;
	}

	private synchronized UserDetailVO saveUserDetail(long userId, WeChatLoginForm form, Map<String, Object> weChatMap) throws DAOException {
		
		String openid = (String)weChatMap.get("openid");
		int sex = (int) weChatMap.get("sex");
		String cityName = (String)weChatMap.get("cityName");
		String picUrl = (String)weChatMap.get("picUrl");
		String accessToken = (String)weChatMap.get("accessToken");
//		String refreshToken = responseObj.getString("refresh_token");
		Long expiresIn = (Long)weChatMap.get("expiresIn");
		
		// user_detail
		long cityId = 0;
		long provinceId = 0;
		String provinceName = "";
		CityVO city = cityDao.findByCityName(cityName);
		if (city != null) {
			cityId = city.getCityId();
			provinceId = city.getProvinceId();
			provinceName = city.getProvinceName();
		}
		
		String userCode = getUserCode();
		
		UserDetailVO userDetail = new UserDetailVO();
		userDetail.setUserId(userId);
		userDetail.setAccessToken(accessToken);
		userDetail.setOpenid(openid);
		userDetail.setExpiresIn(expiresIn);
		userDetail.setSex(sex);
		userDetail.setUserPicture(picUrl);
		userDetail.setCityId(cityId);
		userDetail.setCityName(cityName);
		userDetail.setProvinceId(provinceId);
		userDetail.setProvinceName(provinceName);
//		userDetail.setEquipmentModel(form.getEquipmentModel());
//		userDetail.setEquipmentType(form.getEquipmentType());
//		userDetail.setSoftVersion(form.getSoftVersion());
//		userDetail.setSystemVersion(form.getSystemVersion());
		userDetail.setUserCode(userCode);
		
		
		userDetailDao.saveUserDetail(userDetail);
		return userDetail;
	}
	
}
