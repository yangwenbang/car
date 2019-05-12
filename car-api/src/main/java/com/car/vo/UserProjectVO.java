package com.car.vo;

public class UserProjectVO implements java.io.Serializable {

	private static final Long serialVersionUID = -8554717670905036372L;
	
	private Long userProjectId;
	private Long projectId;
	private Long userId;
	private Long categoryId;
	private String projectName;	
	private String categoryName;
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Long getUserProjectId() {
		return this.userProjectId;
	}

	public void setUserProjectId(Long userProjectId) {
		this.userProjectId = userProjectId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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