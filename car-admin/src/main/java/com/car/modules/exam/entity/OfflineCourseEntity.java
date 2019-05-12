package com.car.modules.car.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-14 18:21:39
 */
@TableName("offline_course")
public class OfflineCourseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 线下机构ID
	 */
	private Long offlineOrganizationId;
	/**
	 * 项目ID
	 */
	private Long projectId;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 课程名称
	 */
	private String courseName;
	/**
	 * 课程介绍
	 */
	private String introduce;
	/**
	 * 课程介绍网址
	 */
	private String introduceUrl;
	/**
	 * 排序
	 */
	private Integer seq;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：线下机构ID
	 */
	public void setOfflineOrganizationId(Long offlineOrganizationId) {
		this.offlineOrganizationId = offlineOrganizationId;
	}
	/**
	 * 获取：线下机构ID
	 */
	public Long getOfflineOrganizationId() {
		return offlineOrganizationId;
	}
	/**
	 * 设置：项目ID
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：项目ID
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * 设置：项目名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置：课程名称
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * 获取：课程名称
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * 设置：课程介绍
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	/**
	 * 获取：课程介绍
	 */
	public String getIntroduce() {
		return introduce;
	}
	/**
	 * 设置：课程介绍网址
	 */
	public void setIntroduceUrl(String introduceUrl) {
		this.introduceUrl = introduceUrl;
	}
	/**
	 * 获取：课程介绍网址
	 */
	public String getIntroduceUrl() {
		return introduceUrl;
	}
	/**
	 * 设置：排序
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSeq() {
		return seq;
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
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
