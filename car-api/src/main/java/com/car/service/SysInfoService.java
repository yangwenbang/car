package com.car.service;

import com.car.entity.SysInfo;
import com.car.exception.DAOException;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface SysInfoService {

	void saveSysInfo(SysInfo sysInfo) throws DAOException;
	
}
