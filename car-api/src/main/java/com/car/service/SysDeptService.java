package com.car.service;

import com.car.exception.DAOException;
import com.car.vo.SysDeptVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface SysDeptService {

	SysDeptVO findFirstSysDept() throws DAOException;
	
}
