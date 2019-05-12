package com.car.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.UserCourseRecordDao;
import com.car.entity.UserCourseRecord;
import com.car.exception.DAOException;
import com.car.service.UserCourseRecordService;

@Service("usrCourseRecordService")
public class UsreCourseRecordServiceImpl implements UserCourseRecordService {
	@Autowired
	private UserCourseRecordDao usreCourseRecordDao;

	@Override
	public int getBuyCountByCargo(long cargoId, int cargoType) throws DAOException {
		return usreCourseRecordDao.getBuyCountByCargo(cargoId, cargoType);
	}




}
