package com.car.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.UserCoinDao;
import com.car.exception.DAOException;
import com.car.service.UserCoinService;
import com.car.vo.PayRecordVO;

@Service("userCoinService")
public class UserCoinServiceImpl implements UserCoinService {
	@Autowired
	private UserCoinDao userCoinDao;

	@Override
	public PayRecordVO findByUser(long userId) throws DAOException {
		return null;
	}



}
