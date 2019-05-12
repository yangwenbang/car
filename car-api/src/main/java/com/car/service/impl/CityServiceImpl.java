package com.car.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.CityDao;
import com.car.exception.DAOException;
import com.car.service.CityService;
import com.car.vo.CityVO;

@Service("cityService")
public class CityServiceImpl implements CityService {
	@Autowired
	private CityDao cityDao;

	@Override
	public CityVO findByCityName(String cityName) throws DAOException {
		return cityDao.findByCityName(cityName);
	}

	@Override
	public List<CityVO> getCitysByProvince(long provinceId) throws DAOException {
		return cityDao.getCitysByProvince(provinceId);
	}


}
