package com.car.service;

import com.car.exception.DAOException;
import com.car.vo.VipRecordVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface VipRecordService {

	VipRecordVO findVipRecordByUserAndProject(long userId, long projectId) throws DAOException;
	
	String buyVipByProject(long userId, long vipContentId) throws DAOException;
	
}
