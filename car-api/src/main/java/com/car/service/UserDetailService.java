package com.car.service;


import com.car.exception.DAOException;
import com.car.form.MobileLoginForm;
import com.car.vo.UserDetailVO;
import com.car.vo.UserVO;

/**
 * 用户
 * 
 * @author wind
 */
public interface UserDetailService {

	UserDetailVO getUserDetailByCondition(long userId) throws DAOException;
	
	void saveUserDetail(UserDetailVO userDetail) throws DAOException;

	void updateUserDetail(UserDetailVO userDetail) throws DAOException;
	
	
}
