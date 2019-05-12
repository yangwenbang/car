package com.car.dao;

import com.car.exception.DAOException;
import com.car.vo.UserDetailVO;

/**
 * 用户
 * 
 * @author wind
 */
public interface UserDetailDao {

	UserDetailVO getUserDetailByCondition(long userId) throws DAOException;
	
	void saveUserDetail(UserDetailVO userDetail) throws DAOException;

	void updateUserDetail(UserDetailVO userDetail) throws DAOException;
	
	String getMaxUserCode() throws DAOException;

}
