package com.car.dao;

import com.car.entity.UserCoin;
import com.car.exception.DAOException;
import com.car.vo.PayRecordVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface UserCoinDao {

	PayRecordVO findByUser(long userId) throws DAOException;
	
	void saveUserCoin(UserCoin userCoin) throws DAOException;
	
	void updateUserCoin(UserCoin userCoin) throws DAOException;
	
	UserCoin getUserCoinEntityByUser(long userId) throws DAOException;
	
}
