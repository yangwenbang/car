package com.car.dto;

import java.io.Serializable;
import java.util.List;

import com.car.vo.CategoryVO;

public class ProjectCategoryDTO implements Serializable {
	
	private static final long serialVersionUID = -9103443426969787350L;
	private Long projectId;
	private String projectName;
	private List<CategoryVO> categorys;
	
	public ProjectCategoryDTO() {}

	public ProjectCategoryDTO(Long projectId, String projectName, List<CategoryVO> categorys) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.categorys = categorys;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<CategoryVO> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<CategoryVO> categorys) {
		this.categorys = categorys;
	}
}
