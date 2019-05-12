package com.car.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.car.entity.UserAddress;
import com.car.exception.DAOException;
import com.car.vo.UserAddressVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface UserAddressDao {
	

	List<UserAddressVO> getUserAddressByUser(long userId) throws DAOException;
	
	void saveUserAddress(UserAddress userAddress) throws DAOException;
	
	void updateUserAddress(UserAddress userAddress) throws DAOException;
	
	void deleteUserAddress(long userAddressId) throws DAOException;
	
	UserAddress findById(long userAddressId) throws DAOException;
	
	UserAddress getUserDefaultAddress(int isDefalut) throws DAOException;
	
	void updateUserDefaultAddress(@Param("userAddressId") long userAddressId,
			@Param("isDefault") int isDefault,
			@Param("updateTime") Date updateTime) throws DAOException;
}
