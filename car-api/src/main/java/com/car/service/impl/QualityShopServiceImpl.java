package com.car.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.ApiConstants;
import com.car.dao.QualityShopDao;
import com.car.exception.DAOException;
import com.car.service.QualityShopService;
import com.car.vo.QualityShopVO;


@Service("qualityShopService")
public class QualityShopServiceImpl implements QualityShopService {

    @Autowired
    private QualityShopDao qualityShopDao;

	@Override
	public List<QualityShopVO> getQualityShops(int pageId) throws DAOException {
		int pageSize = pageId * ApiConstants.PAGE_COUNT;
		return qualityShopDao.getQualityShops(pageSize, ApiConstants.PAGE_COUNT);
	}

}
