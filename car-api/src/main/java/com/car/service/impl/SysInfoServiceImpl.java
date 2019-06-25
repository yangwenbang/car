package com.car.service.impl;


import com.car.vo.SysInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.SysInfoDao;
import com.car.entity.SysInfo;
import com.car.exception.DAOException;
import com.car.service.SysInfoService;

import java.util.List;

@Service("sysInfoService")
public class SysInfoServiceImpl implements SysInfoService {
	@Autowired
	private SysInfoDao sysInfoDao;

	@Override
	public void saveSysInfo(SysInfo sysInfo) throws DAOException {
		sysInfoDao.saveSysInfo(sysInfo);
	}

	@Override
	public List<SysInfoVO> queryUserInfosByUserId(Long userId) throws DAOException {
		return sysInfoDao.queryUserInfosByUserId(userId);
	}

	@Override
	public void deleteUserInfoById(Long sysInfoId) throws DAOException {
		sysInfoDao.deleteUserInfoById(sysInfoId);
	}


}
