package com.car.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car.dao.UserAddressDao;
import com.car.entity.UserAddress;
import com.car.exception.DAOException;
import com.car.form.UserAddressForm;
import com.car.service.UserAddressService;
import com.car.vo.UserAddressVO;

@Service("userAddressService")
public class UserAddressServiceImpl implements UserAddressService {
	@Autowired
	private UserAddressDao userAddressDao;

	@Override
	public List<UserAddressVO> getUserAddressByUser(long userId) throws DAOException {
		return userAddressDao.getUserAddressByUser(userId);
	}

	@Override
	@Transactional
	public void saveUserAddress(UserAddressForm userAddressForm) throws DAOException {
		
		int isDefault = userAddressForm.getIsDefault();
		if (isDefault == 1) {
			clearUserDefaultAddress();
		}
		
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(userAddressForm.getUserId());
		userAddress.setAddress(userAddressForm.getAddress());
		userAddress.setDetailAddress(userAddressForm.getDetailAddress());
		userAddress.setMobile(userAddressForm.getMobile());
		userAddress.setReceiver(userAddressForm.getReceiver());
		userAddress.setPostcode(userAddressForm.getPostcode());
		userAddress.setIsDefault(userAddressForm.getIsDefault());
		userAddress.setCreateTime(new Date());
		userAddress.setUpdateTime(new Date());
		
		userAddressDao.saveUserAddress(userAddress);
	}

	@Override
	@Transactional
	public void updateUserAddress(UserAddressForm userAddressForm) throws DAOException {
		
		long userAddressId = userAddressForm.getUserAddressId();
		int isDefault = userAddressForm.getIsDefault();
		if (isDefault == 1) {
			clearUserDefaultAddress();
		}
		
		UserAddress userAddress = userAddressDao.findById(userAddressId);
		if (userAddress != null) {
			userAddress.setAddress(userAddressForm.getAddress());
			userAddress.setDetailAddress(userAddressForm.getDetailAddress());
			userAddress.setIsDefault(userAddressForm.getIsDefault());
			userAddress.setMobile(userAddressForm.getMobile());
			userAddress.setPostcode(userAddressForm.getPostcode());
			userAddress.setReceiver(userAddressForm.getReceiver());
			userAddress.setUpdateTime(new Date());
			userAddressDao.updateUserAddress(userAddress);
		}
		
	}

	@Override
	public void deleteUserAddress(long userAddressId) throws DAOException {
		userAddressDao.deleteUserAddress(userAddressId);
	}

	private void clearUserDefaultAddress() throws DAOException {
		UserAddress userAdr = userAddressDao.getUserDefaultAddress(1);
		if (userAdr != null) {
			userAddressDao.updateUserDefaultAddress(userAdr.getId(), 0, new Date());
		}
	}

}
