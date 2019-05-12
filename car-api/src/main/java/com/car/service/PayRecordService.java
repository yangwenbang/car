package com.car.service;

import com.car.entity.PayRecord;
import com.car.exception.DAOException;
import com.car.vo.PayRecordVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface PayRecordService {

	PayRecordVO findByUserAndOrderNo(long userId, String orderNo) throws DAOException;

	void savePayRecord(PayRecord payRecord) throws DAOException;
	
	long getMaxPayRecordId() throws DAOException;
	
	void saveBuyInfo(String orderNo) throws DAOException;
	
}
