package com.car.service;

import com.car.exception.DAOException;
import com.car.vo.EquipmentManagerVO;

/**
 * @author wind
 */
public interface EquipmentManagerService {
	
	EquipmentManagerVO getLastEquipmentManagerByType(int type) throws DAOException;
	
}
