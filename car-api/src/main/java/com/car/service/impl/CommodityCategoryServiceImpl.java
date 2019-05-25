package com.car.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.CommodityCategoryDao;
import com.car.exception.DAOException;
import com.car.service.CommodityCategoryService;
import com.car.vo.CommodityCategoryVO;


@Service("commodityCategoryService")
public class CommodityCategoryServiceImpl implements CommodityCategoryService {
	
	@Autowired
	private CommodityCategoryDao commodityCategoryDao;

	@Override
	public List<CommodityCategoryVO> queryCommodityCategorys() throws DAOException {
		return commodityCategoryDao.queryCommodityCategorys();
	}


}
