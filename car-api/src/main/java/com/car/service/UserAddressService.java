package com.car.service;

import java.util.List;

import com.car.entity.UserAddress;
import com.car.exception.DAOException;
import com.car.form.UserAddressForm;
import com.car.vo.UserAddressVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface UserAddressService {

	List<UserAddressVO> getUserAddressByUser(long userId) throws DAOException;
	
	void saveUserAddress(UserAddressForm userAddressForm) throws DAOException;
	
	void updateUserAddress(UserAddressForm userAddressForm) throws DAOException;
	
	void deleteUserAddress(long userAddressId) throws DAOException;
	
}
