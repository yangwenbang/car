package com.car.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.UserDetailDao;
import com.car.exception.DAOException;
import com.car.service.UserDetailService;
import com.car.vo.UserDetailVO;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailService {
	
	@Autowired
	private UserDetailDao userDetailDao;

	@Override
	public UserDetailVO getUserDetailByCondition(long userId) throws DAOException {
		return userDetailDao.getUserDetailByCondition(userId);
	}

	@Override
	public void saveUserDetail(UserDetailVO userDetail) throws DAOException {
		userDetailDao.saveUserDetail(userDetail);
	}

	@Override
	public void updateUserDetail(UserDetailVO userDetail) throws DAOException {
		userDetailDao.updateUserDetail(userDetail);
	}
	
}
