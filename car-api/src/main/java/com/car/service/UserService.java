package com.car.service;


import java.util.Map;

import com.car.exception.DAOException;
import com.car.form.LoginForm;
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
	UserVO login(LoginForm form) throws DAOException;

	UserVO findById(long userId) throws DAOException;
	
	UserVO weChatLogin(LoginForm form) throws Exception;
	
}
