package com.car.dao;

import com.car.entity.SysInfo;
import com.car.exception.DAOException;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface SysInfoDao {

	void saveSysInfo(SysInfo sysInfo) throws DAOException;
	
}
