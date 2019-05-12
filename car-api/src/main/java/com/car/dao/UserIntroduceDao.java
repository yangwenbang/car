package com.car.dao;

import com.car.exception.DAOException;
import com.car.vo.UserIntroduceVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface UserIntroduceDao {

	UserIntroduceVO findByOpenid(String openid) throws DAOException;
	
}
