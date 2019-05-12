package com.car.dao;

import org.apache.ibatis.annotations.Param;

import com.car.entity.PayRecord;
import com.car.exception.DAOException;
import com.car.vo.PayRecordVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface PayRecordDao {

	PayRecordVO findByUserAndOrderNo(@Param("userId") long userId,
			@Param("orderNo") String orderNo) throws DAOException;
	
	void savePayRecord(PayRecord payRecord) throws DAOException;
	
	void updatePayRecordStatus(PayRecordVO payRecord) throws DAOException;
	
	long getMaxPayRecordId() throws DAOException;
	
	PayRecordVO getPayRecordByOrderNo(@Param("orderNo") String orderNo,
			@Param("payStatus") int payStatus) throws DAOException;
	
}
