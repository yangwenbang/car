package com.car.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 21:32:24
 */
public class CommodityCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品分类ID
	 */
	private Long id;
	/**
	 * 商品分类父ID
	 */
	private Long parentId;
	/**
	 * 分类名称
	 */
	private String categoryName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;

	/**
	 * 设置：商品分类ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：商品分类ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：商品分类父ID
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：商品分类父ID
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：分类名称
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * 获取：分类名称
	 */
	public String getCategoryName() {
		return categoryName;
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
