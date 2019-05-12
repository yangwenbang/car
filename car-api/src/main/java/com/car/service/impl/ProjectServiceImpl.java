package com.car.service.impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.car.dao.ProjectDao;
import com.car.dto.ProjectCategoryDTO;
import com.car.exception.DAOException;
import com.car.service.ProjectService;
import com.car.vo.CategoryVO;
import com.car.vo.ProjectCategoryVO;
import com.car.vo.ProjectVO;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectDao;

	@Override
	public ProjectVO getProjectByProjectId(long projectId) throws DAOException {
		return projectDao.getProjectByProjectId(projectId);
	}

	@Override
	public List<ProjectVO> getProjects() throws DAOException {
		return projectDao.getProjects();
	}

	@Override
	public List<ProjectCategoryDTO> getProjectCategorys() throws DAOException {
		Map<ProjectVO, List<CategoryVO>> projectCategoryMap = new LinkedHashMap<>();
		List<ProjectCategoryVO> projectCategorys = projectDao.getProjectCategorys();
		if (CollectionUtils.isEmpty(projectCategorys)) {
			return Collections.emptyList();
		}
		
		ProjectVO project = null;
		CategoryVO category = null;
		List<CategoryVO> categorys = null;
		for (ProjectCategoryVO projectCategory : projectCategorys) {
			project = new ProjectVO(projectCategory.getProjectId(), projectCategory.getProjectName());
			category = new CategoryVO(projectCategory.getCategoryId(), projectCategory.getCategoryName());
			if (projectCategoryMap.containsKey(project)) {
				categorys.add(category);
				projectCategoryMap.put(project, categorys);
			} else {
				categorys = new ArrayList<>();
				categorys.add(category);
				projectCategoryMap.put(project, categorys);
			}
			project = null;
			category = null;
		}
		
		// 组手机端的数据
		List<ProjectCategoryDTO> dtos = new ArrayList<>();
		Set<Entry<ProjectVO, List<CategoryVO>>> entrySet = projectCategoryMap.entrySet();
		for (Entry<ProjectVO, List<CategoryVO>> entry : entrySet) {
			ProjectVO projectVO = entry.getKey();
			List<CategoryVO> categoryVOs = entry.getValue();
			dtos.add(new ProjectCategoryDTO(projectVO.getProjectId(), projectVO.getProjectName(), categoryVOs));
		}
		
		return dtos;
	}


}
