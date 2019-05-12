package com.car.service;

import com.car.exception.DAOException;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface UserCourseRecordService {
	
	int getBuyCountByCargo(long cargoId, int cargoType) throws DAOException;
	
}
