package com.car.service.impl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.CategoryDao;
import com.car.dao.ProjectDao;
import com.car.dao.UserProjectDao;
import com.car.entity.UserProject;
import com.car.exception.DAOException;
import com.car.form.UserProjectForm;
import com.car.service.UserProjectService;
import com.car.vo.CategoryVO;
import com.car.vo.ProjectVO;
import com.car.vo.UserProjectVO;

@Service("userProjectService")
public class UserProjectServiceImpl implements UserProjectService {
	@Autowired
	private UserProjectDao userProjectDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void saveUserProject(UserProjectForm userProjectForm) throws DAOException {
		
		if (userProjectForm == null || 
				userProjectForm.getUserId() == null || 
				userProjectForm.getProjectId() == null ||
				userProjectForm.getCategoryId() == null) {
			throw new DAOException("userProjectForm is null");
		}
		
		long userId = userProjectForm.getUserId();
		long projectId = userProjectForm.getProjectId();
		long categoryId = userProjectForm.getCategoryId();
		
		ProjectVO project = projectDao.getProjectByProjectId(projectId);
		CategoryVO category = categoryDao.findCategoryByCategoryId(categoryId);
		
		UserProject userProject = new UserProject();
		userProject.setUserId(userId);
		userProject.setProjectId(projectId);
		if(project != null) {
			userProject.setProjectName(project.getProjectName());
		}
		userProject.setCategoryId(categoryId);
		if (category != null) {
			userProject.setCategoryName(category.getCategoryName());
		}
		userProject.setLastUpdateDate(new Date());
		userProjectDao.saveUserProject(userProject);
		userProject = null;
		
	}

	@Override
	public UserProjectVO getUserNewestProjectByUser(long userId) throws DAOException {
		return userProjectDao.getUserNewestProjectByUser(userId);
	}

	@Override
	public UserProjectVO getUserProjectByProject(long userId, long projectId) throws DAOException {
		return userProjectDao.getUserProjectByProject(userId, projectId);
	}

	@Override
	public void updateUserProjectVipDate(long userProjectId, Date vipDate) throws DAOException {
		userProjectDao.updateUserProjectVipDate(userProjectId, vipDate);
	}

}
