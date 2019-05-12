package com.car.modules.car.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-23 00:54:34
 */
@TableName("project")
public class ProjectEntity extends Model<ProjectEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 项目id
	 */
	@TableId
	private Long id;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 项目图片
	 */
	private String projectPicture;
	/**
	 * 项目描述
	 */
	private String projectDesc;
	/**
	 * 是否有效(0无效/1有效)
	 */
	private Integer effective;
	/**
	 * 排序
	 */
	private Integer seq;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 设置：项目id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：项目id
	 */
	public Long getId() {
		return id;
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
	 * 设置：项目图片
	 */
	public void setProjectPicture(String projectPicture) {
		this.projectPicture = projectPicture;
	}
	/**
	 * 获取：项目图片
	 */
	public String getProjectPicture() {
		return projectPicture;
	}
	/**
	 * 设置：项目描述
	 */
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	/**
	 * 获取：项目描述
	 */
	public String getProjectDesc() {
		return projectDesc;
	}
	/**
	 * 设置：是否有效(0无效/1有效)
	 */
	public void setEffective(Integer effective) {
		this.effective = effective;
	}
	/**
	 * 获取：是否有效(0无效/1有效)
	 */
	public Integer getEffective() {
		return effective;
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
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
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
