package com.car.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.ProvinceDao;
import com.car.exception.DAOException;
import com.car.service.ProvinceService;
import com.car.vo.ProvinceVO;

@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService {
	@Autowired
	private ProvinceDao provinceDao;

	@Override
	public List<ProvinceVO> getProvinces() throws DAOException {
		return provinceDao.getProvinces();
	}

	


}
