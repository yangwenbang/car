package com.car.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.AdvertisementDao;
import com.car.exception.DAOException;
import com.car.service.AdvertisementService;
import com.car.vo.AdvertisementVO;

@Service("advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService {
	@Autowired
	private AdvertisementDao advertisementDao;

	@Override
	public List<AdvertisementVO> getAdvertisementsByProject(long projectId) throws DAOException {
		return advertisementDao.getAdvertisementsByProject(projectId);
	}


}
