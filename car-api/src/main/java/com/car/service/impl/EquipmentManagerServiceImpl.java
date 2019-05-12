package com.car.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.EquipmentManagerDao;
import com.car.exception.DAOException;
import com.car.service.EquipmentManagerService;
import com.car.vo.EquipmentManagerVO;

@Service("equipmentManagerService")
public class EquipmentManagerServiceImpl implements EquipmentManagerService {
	@Autowired
	private EquipmentManagerDao equipmentManagerDao;

	@Override
	public EquipmentManagerVO getLastEquipmentManagerByType(int type) throws DAOException {
		return equipmentManagerDao.getLastEquipmentManagerByType(type);
	}

}
