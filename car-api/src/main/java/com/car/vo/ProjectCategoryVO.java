package com.car.vo;

import java.io.Serializable;

public class ProjectCategoryVO implements Serializable {
	
	private static final long serialVersionUID = -113209605039800606L;
	
	private Long projectId;
	private String projectName;
	private Long categoryId;
	private String categoryName;

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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
