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
 * @date 2019-01-23 00:54:45
 */
@TableName("category")
public class CategoryEntity extends Model<CategoryEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 分类id
	 */
	@TableId
	private Long id;
	/**
	 * 项目id
	 */
	private Long projectId;
	/**
	 * 分类名字
	 */
	private String categoryName;
	/**
	 * 分类描述
	 */
	private String categoryDesc;
	/**
	 * 分类图片
	 */
	private String categoryPicture;
	/**
	 * 是否有效
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
	 * 设置：分类id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：分类id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：项目id
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：项目id
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * 设置：分类名字
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * 获取：分类名字
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * 设置：分类描述
	 */
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	/**
	 * 获取：分类描述
	 */
	public String getCategoryDesc() {
		return categoryDesc;
	}
	/**
	 * 设置：分类图片
	 */
	public void setCategoryPicture(String categoryPicture) {
		this.categoryPicture = categoryPicture;
	}
	/**
	 * 获取：分类图片
	 */
	public String getCategoryPicture() {
		return categoryPicture;
	}
	/**
	 * 设置：是否有效
	 */
	public void setEffective(Integer effective) {
		this.effective = effective;
	}
	/**
	 * 获取：是否有效
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
