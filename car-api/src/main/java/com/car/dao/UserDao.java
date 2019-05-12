
package com.car.dao;

import org.apache.ibatis.annotations.Param;

import com.car.entity.UserEntity;
import com.car.exception.DAOException;
import com.car.vo.UserVO;

/**
 * 用户
 * 
 * @author wind
 */
public interface UserDao {

	UserVO findUserByCondition(@Param("mobile") String mobile, @Param("password")  String password) throws DAOException;

	UserVO findUserVOByMobile(String mobile) throws DAOException;

	void updateUserMobile(@Param("userId") long userId, @Param("password") String password) throws DAOException;

	void saveUser(UserEntity userEntity) throws DAOException;
	
	UserVO findById(long userId) throws DAOException;
	
	UserVO findUserByOpenid(String openid) throws DAOException;
	
	UserVO findUserByOpenidAndPassword(@Param("openid") String openid, @Param("password")  String password) throws DAOException;
	
	int getUserCount() throws DAOException;

}
