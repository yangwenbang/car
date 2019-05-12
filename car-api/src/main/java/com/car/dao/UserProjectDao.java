package com.car.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.car.entity.UserProject;
import com.car.exception.DAOException;
import com.car.vo.UserProjectVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface UserProjectDao {
	
	void saveUserProject(UserProject userPorject) throws DAOException;
	
	List<UserProjectVO> getUserProjectsByUser(long userId) throws DAOException;
	
	UserProjectVO getUserNewestProjectByUser(long userId) throws DAOException;
	
	UserProjectVO getUserProjectByProject(@Param("userId") long userId,
			@Param("projectId") long projectId) throws DAOException;
	
	void updateUserProjectVipDate(@Param("userProjectId") long userProjectId,
			@Param("vipDate") Date vipDate) throws DAOException;

}
