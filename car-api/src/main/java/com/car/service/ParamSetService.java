package com.car.service;

import com.car.exception.DAOException;
import com.car.vo.ParamSetVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface ParamSetService {

	ParamSetVO getParamSetVO() throws DAOException;
	
}
