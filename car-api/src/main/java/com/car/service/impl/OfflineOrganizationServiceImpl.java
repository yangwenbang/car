package com.car.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.OfflineOrganizationDao;
import com.car.exception.DAOException;
import com.car.service.OfflineOrganizationService;
import com.car.vo.OfflineOrganizationVO;

@Service("offlineOrganizationService")
public class OfflineOrganizationServiceImpl implements OfflineOrganizationService {
	@Autowired
	private OfflineOrganizationDao offlineOrganizationDao;

	@Override
	public OfflineOrganizationVO findOfflineOrganizationByCode(String organizationCode) throws DAOException {
		return offlineOrganizationDao.findOfflineOrganizationByCode(organizationCode);
	}

	


}
