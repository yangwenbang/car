package com.car.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ProjectVO implements Serializable {
	
	private static final long serialVersionUID = -1482790472846061842L;
	
	private Long projectId;
	private String projectName;
	
	public ProjectVO() {
	}

	public ProjectVO(Long projectId, String projectName) {
		this.projectId = projectId;
		this.projectName = projectName;
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
	
	public String toString() {
		return new ToStringBuilder(this).append("id", getProjectId()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getProjectId()).toHashCode();
	}

	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof ProjectVO)) {
			return false;
		}
		ProjectVO castOther = (ProjectVO) other;
		return new EqualsBuilder().append(this.getProjectId(), castOther.getProjectId())
				.isEquals();
	}
}
