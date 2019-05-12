package com.car.dao;

import java.util.List;

import com.car.exception.DAOException;
import com.car.vo.CityVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface CityDao {

	CityVO findByCityName(String cityName) throws DAOException;
	
	List<CityVO> getCitysByProvince(long provinceId) throws DAOException;
}
