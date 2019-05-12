package com.car.dao;

import com.car.exception.DAOException;
import com.car.vo.EquipmentManagerVO;

public interface EquipmentManagerDao {
	
	EquipmentManagerVO getLastEquipmentManagerByType(int type) throws DAOException;
}