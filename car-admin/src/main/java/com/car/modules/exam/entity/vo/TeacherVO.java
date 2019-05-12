package com.car.modules.car.entity.vo;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-22 19:04:25
 */
@Service
public class TeacherVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String teacherMobile;
	private String teacherPassword;
	private String teacherName;
	private Integer sex;
	private Long cityId;
	private String homeAddress;
	private String teacherSpecial;
	private String teacherLength;
	private String education;
	private String headPictureUrl;
	private Integer isFamous;
	private String subjectName;
	private String cityName;

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setTeacherMobile(String teacherMobile) {
		this.teacherMobile = teacherMobile;
	}
	public String getTeacherMobile() {
		return teacherMobile;
	}
	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}
	public String getTeacherPassword() {
		return teacherPassword;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getSex() {
		return sex;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setTeacherSpecial(String teacherSpecial) {
		this.teacherSpecial = teacherSpecial;
	}
	public String getTeacherSpecial() {
		return teacherSpecial;
	}
	public void setTeacherLength(String teacherLength) {
		this.teacherLength = teacherLength;
	}
	public String getTeacherLength() {
		return teacherLength;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getEducation() {
		return education;
	}
	public void setHeadPictureUrl(String headPictureUrl) {
		this.headPictureUrl = headPictureUrl;
	}
	public String getHeadPictureUrl() {
		return headPictureUrl;
	}
	public void setIsFamous(Integer isFamous) {
		this.isFamous = isFamous;
	}
	public Integer getIsFamous() {
		return isFamous;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityName() {
		return cityName;
	}
}
