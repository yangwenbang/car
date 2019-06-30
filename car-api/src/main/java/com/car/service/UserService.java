package com.car.service;


import com.car.exception.DAOException;
import com.car.form.MobileLoginForm;
import com.car.form.WeChatLoginForm;
import com.car.vo.UserVO;

/**
 * 用户
 * 
 * @author wind
 */
public interface UserService {

//	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return        返回登录信息
	 */
	UserVO login(MobileLoginForm form) throws DAOException;

	UserVO findById(long userId) throws DAOException;
	
	UserVO weChatLogin(WeChatLoginForm form) throws Exception;
	
}
