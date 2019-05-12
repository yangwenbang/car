package com.car.dao;

import org.apache.ibatis.annotations.Param;

import com.car.entity.VipRecord;
import com.car.exception.DAOException;
import com.car.vo.VipRecordVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06  
 */
public interface VipRecordDao {
	
	VipRecordVO findVipRecordByUserAndProject(@Param("userId") long userId, 
			@Param("projectId") long projectId) throws DAOException;
	
	VipRecord findVipRecordEntityByUserAndProject(@Param("userId") long userId, 
			@Param("projectId") long projectId) throws DAOException;
	
	void saveVipRecord(VipRecord vipRecord) throws DAOException;
	
	void updateVipReocrd(VipRecord vipRecord) throws DAOException;

}
