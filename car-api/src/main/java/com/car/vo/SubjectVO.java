package com.car.vo;

import java.io.Serializable;

public class SubjectVO implements Serializable {

	private static final Long serialVersionUID = -5674804418382387767L;
	
	private Long subjectId;
	private String subjectName;
	private String subjectDesc;

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectDesc() {
		return subjectDesc;
	}

	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}

}