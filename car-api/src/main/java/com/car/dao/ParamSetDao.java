package com.car.dao;

import com.car.exception.DAOException;
import com.car.vo.ParamSetVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface ParamSetDao {

	ParamSetVO getParamSetVO() throws DAOException;
	
}
