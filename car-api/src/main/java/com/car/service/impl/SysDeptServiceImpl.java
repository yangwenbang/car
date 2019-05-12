package com.car.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.SysDeptDao;
import com.car.exception.DAOException;
import com.car.service.SysDeptService;
import com.car.vo.SysDeptVO;

@Service("sysDeptService")
public class SysDeptServiceImpl implements SysDeptService {
	@Autowired
	private SysDeptDao sysDeptDao;

	@Override
	public SysDeptVO findFirstSysDept() throws DAOException {
		return sysDeptDao.findFirstSysDept();
	}

	


}
