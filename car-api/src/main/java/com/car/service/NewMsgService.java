package com.car.service;

import java.util.List;

import com.car.exception.DAOException;
import com.car.vo.NewMsgVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface NewMsgService {

	List<NewMsgVO> getLastNewMsgsByProject(long projectId) throws DAOException;
	
	List<NewMsgVO> getNewMsgsByProject(long projectId) throws DAOException;
	
}
