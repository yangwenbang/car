package com.car.vo;

import java.io.Serializable;
import java.util.List;

public class SubjectAndCourseVO implements Serializable {

	private static final long serialVersionUID = -1006505063106170557L;
	
	private long subjectId;
	private String subjectName;
	private List<CourseVO> courses;
	
	public SubjectAndCourseVO() {
	}
	
	public SubjectAndCourseVO(long subjectId, String subjectName,
			List<CourseVO> courses) {
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.courses = courses;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<CourseVO> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseVO> courses) {
		this.courses = courses;
	}

	

}