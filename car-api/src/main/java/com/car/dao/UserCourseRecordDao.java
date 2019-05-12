package com.car.dao;

import org.apache.ibatis.annotations.Param;

import com.car.entity.UserCourseRecord;
import com.car.exception.DAOException;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface UserCourseRecordDao {
	
	void saveUserCourseRecord(UserCourseRecord userCourseRecord) throws DAOException;
	
	int getBuyCountByCargo(@Param("cargoId") long cargoId,
			@Param("cargoType") int cargoType) throws DAOException;
	
}
