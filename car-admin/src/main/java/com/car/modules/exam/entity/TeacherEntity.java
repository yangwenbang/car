package com.car.modules.car.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
@TableName("teacher")
public class TeacherEntity extends Model<TeacherEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 教师id
	 */
	@TableId
	private Long id;
	/**
	 * 教师手机号
	 */
	@Pattern(regexp="(\\+\\d+)?1[3458]\\d{9}$",message="请输入正确的手机号")
	private String teacherMobile;
	/**
	 * 教师密码
	 */
	@NotBlank(message="请输入密码")
	private String teacherPassword;
	/**
	 * 教师姓名
	 */
	@NotBlank(message="请输入姓名")
	private String teacherName;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 所在城市id
	 */
	private Long cityId;
	/**
	 * 
	 */
	private String homeAddress;
	/**
	 * 邮箱
	 */
	@Email(message = "请输入正确的邮箱地址")
	private String email;
	/**
	 * 教师简介
	 */
	private String teacherIntroduce;
	/**
	 * 教学特长(擅长科目)
	 */
	private String teacherSpecial;
	/**
	 * 教龄
	 */
	private String teacherLength;
	/**
	 * 学历
	 */
	private String education;
	/**
	 * 头像图片网址
	 */
	private String headPictureUrl;
	/**
	 * 名师推荐(0不是/1是)
	 */
	private Integer isFamous;
	/**
	 * 所教科目
	 */
	private String subjectName;
	/**
	 * 一句话
	 */
	private String oneWord;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 设置：教师id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：教师id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：教师手机号
	 */
	public void setTeacherMobile(String teacherMobile) {
		this.teacherMobile = teacherMobile;
	}
	/**
	 * 获取：教师手机号
	 */
	public String getTeacherMobile() {
		return teacherMobile;
	}
	/**
	 * 设置：教师密码
	 */
	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}
	/**
	 * 获取：教师密码
	 */
	public String getTeacherPassword() {
		return teacherPassword;
	}
	/**
	 * 设置：教师姓名
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	/**
	 * 获取：教师姓名
	 */
	public String getTeacherName() {
		return teacherName;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：所在城市id
	 */
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：所在城市id
	 */
	public Long getCityId() {
		return cityId;
	}
	/**
	 * 设置：
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	/**
	 * 获取：
	 */
	public String getHomeAddress() {
		return homeAddress;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：教师简介
	 */
	public void setTeacherIntroduce(String teacherIntroduce) {
		this.teacherIntroduce = teacherIntroduce;
	}
	/**
	 * 获取：教师简介
	 */
	public String getTeacherIntroduce() {
		return teacherIntroduce;
	}
	/**
	 * 设置：教学特长(擅长科目)
	 */
	public void setTeacherSpecial(String teacherSpecial) {
		this.teacherSpecial = teacherSpecial;
	}
	/**
	 * 获取：教学特长(擅长科目)
	 */
	public String getTeacherSpecial() {
		return teacherSpecial;
	}
	/**
	 * 设置：教龄
	 */
	public void setTeacherLength(String teacherLength) {
		this.teacherLength = teacherLength;
	}
	/**
	 * 获取：教龄
	 */
	public String getTeacherLength() {
		return teacherLength;
	}
	/**
	 * 设置：学历
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * 获取：学历
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * 设置：头像图片网址
	 */
	public void setHeadPictureUrl(String headPictureUrl) {
		this.headPictureUrl = headPictureUrl;
	}
	/**
	 * 获取：头像图片网址
	 */
	public String getHeadPictureUrl() {
		return headPictureUrl;
	}
	/**
	 * 设置：名师推荐(0不是/1是)
	 */
	public void setIsFamous(Integer isFamous) {
		this.isFamous = isFamous;
	}
	/**
	 * 获取：名师推荐(0不是/1是)
	 */
	public Integer getIsFamous() {
		return isFamous;
	}
	/**
	 * 设置：所教科目
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	/**
	 * 获取：所教科目
	 */
	public String getSubjectName() {
		return subjectName;
	}
	/**
	 * 设置：一句话
	 */
	public void setOneWord(String oneWord) {
		this.oneWord = oneWord;
	}
	/**
	 * 获取：一句话
	 */
	public String getOneWord() {
		return oneWord;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	@Override
	protected Serializable pkVal() {
		return id;
	}
}
