package com.car.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.NewMsgDao;
import com.car.exception.DAOException;
import com.car.service.NewMsgService;
import com.car.vo.NewMsgVO;

@Service("newMsgService")
public class NewMsgServiceImpl implements NewMsgService {
	@Autowired
	private NewMsgDao newMsgDao;

	@Override
	public List<NewMsgVO> getLastNewMsgsByProject(long projectId) throws DAOException {
		return newMsgDao.getLastNewMsgsByProject(projectId);
	}

	@Override
	public List<NewMsgVO> getNewMsgsByProject(long projectId) throws DAOException {
		return newMsgDao.getNewMsgsByProject(projectId);
	}

	

}
