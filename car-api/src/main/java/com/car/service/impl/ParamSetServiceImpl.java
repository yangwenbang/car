package com.car.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.ParamSetDao;
import com.car.exception.DAOException;
import com.car.service.ParamSetService;
import com.car.vo.ParamSetVO;

@Service("paramSetService")
public class ParamSetServiceImpl implements ParamSetService {
	@Autowired
	private ParamSetDao paramSetDao;

	@Override
	public ParamSetVO getParamSetVO() throws DAOException {
		return paramSetDao.getParamSetVO();
	}

	


}
