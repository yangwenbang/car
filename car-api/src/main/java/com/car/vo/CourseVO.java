package com.car.vo;

import java.io.Serializable;
import java.util.Date;

public class CourseVO implements Serializable {

	private static final long serialVersionUID = -7779230312874131278L;
	private long courseId;
	private String courseName;
	private String pictureUrl;
	private String oneWord;
	private String introduce;
	private Long teacherId;
	private Integer courseCount;
	private double price;
	private String teacherName;
	private float actualMoney;
	private String buyDate;
	private long subjectId;
	private String subjectName;
	private long projectId;
	private String projectName;
	private long categoryId;
	private String categoryName;
	private String courseUrl;

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getOneWord() {
		return oneWord == null ? "" : oneWord;
	}

	public void setOneWord(String oneWord) {
		this.oneWord = oneWord;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getCourseCount() {
		return courseCount;
	}

	public void setCourseCount(Integer courseCount) {
		this.courseCount = courseCount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public float getActualMoney() {
		return actualMoney;
	}

	public void setActualMoney(float actualMoney) {
		this.actualMoney = actualMoney;
	}

	public String getBuyDate() {
		return buyDate == null ? "" : buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
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

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName == null ? "" : projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName == null ? "" : categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCourseUrl() {
		return courseUrl;
	}

	public void setCourseUrl(String courseUrl) {
		this.courseUrl = courseUrl;
	}

}