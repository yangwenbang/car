package com.car.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.VipContentDao;
import com.car.exception.DAOException;
import com.car.service.VipContentService;
import com.car.vo.VipContentVO;

@Service("vipContentService")
public class VipContentServiceImpl implements VipContentService {
	@Autowired
	private VipContentDao vipContentDao;

	@Override
	public List<VipContentVO> getVipContentsByProject(long projectId) throws DAOException {
		return vipContentDao.getVipContentsByProject(projectId);
	}

	@Override
	public VipContentVO findByPK(long vipContentId) throws DAOException {
		return vipContentDao.findByPK(vipContentId);
	}


}
