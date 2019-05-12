package com.car.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.SysDictDao;
import com.car.exception.DAOException;
import com.car.service.SysDictService;
import com.car.vo.ParamSetVO;
import com.car.vo.SysDictVO;

@Service("sysDictService")
public class SysDictServiceImpl implements SysDictService {
	@Autowired
	private SysDictDao sysDictDao;

	@Override
	public SysDictVO getSysDictVOByType(String type) throws DAOException {
		return sysDictDao.getSysDictVOByType(type);
	}


}
