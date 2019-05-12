package com.car.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.SysInfoDao;
import com.car.entity.SysInfo;
import com.car.exception.DAOException;
import com.car.service.SysInfoService;

@Service("sysInfoService")
public class SysInfoServiceImpl implements SysInfoService {
	@Autowired
	private SysInfoDao sysInfoDao;

	@Override
	public void saveSysInfo(SysInfo sysInfo) throws DAOException {
		sysInfoDao.saveSysInfo(sysInfo);
	}



}
