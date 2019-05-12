package com.car.service;

import java.util.List;

import com.car.dto.ProjectCategoryDTO;
import com.car.exception.DAOException;
import com.car.vo.ProjectVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface ProjectService {
	
	ProjectVO getProjectByProjectId(long projectId) throws DAOException;
	
	List<ProjectVO> getProjects() throws DAOException;
	
	List<ProjectCategoryDTO> getProjectCategorys() throws DAOException;
	
}
