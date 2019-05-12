package com.car.service;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.car.exception.DAOException;
import com.car.form.UserProjectForm;
import com.car.vo.UserProjectVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface UserProjectService {

	void saveUserProject(UserProjectForm userProjectForm) throws DAOException;
	
	UserProjectVO getUserNewestProjectByUser(long userId) throws DAOException;
	
	UserProjectVO getUserProjectByProject(long userId, long projectId) throws DAOException;
	
	void updateUserProjectVipDate(long userProjectId, Date vipDate) throws DAOException;

	
}
