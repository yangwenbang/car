package com.car.dao;

import java.util.List;

import com.car.exception.DAOException;
import com.car.vo.ProjectCategoryVO;
import com.car.vo.ProjectVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface ProjectDao {

	ProjectVO getProjectByProjectId(long projectId) throws DAOException;
	
	List<ProjectVO> getProjects() throws DAOException;
	
	List<ProjectCategoryVO> getProjectCategorys() throws DAOException;
	
}
