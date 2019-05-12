package com.car.dao;

import java.util.List;

import com.car.exception.DAOException;
import com.car.vo.CityVO;
import com.car.vo.ProvinceVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface ProvinceDao {
	
	List<ProvinceVO> getProvinces() throws DAOException;

}
