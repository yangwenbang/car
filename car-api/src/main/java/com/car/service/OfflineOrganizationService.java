package com.car.service;

import com.car.exception.DAOException;
import com.car.vo.OfflineOrganizationVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface OfflineOrganizationService {

	OfflineOrganizationVO findOfflineOrganizationByCode(String organizationCode) throws DAOException;
	
}
