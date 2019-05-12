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
@TableName("offline_customer")
public class OfflineCustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 线下课程ID
	 */
	private Long offlineCourseId;
	/**
	 * 客服类型ID(type=customer)
	 */
	private Long sysDictId;
	/**
	 * 客服类型名称
	 */
	private String customerName;
	/**
	 * 客服类型值(qq号，微信号)
	 */
	private Integer customerVlaue;
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
	 * 设置：线下课程ID
	 */
	public void setOfflineCourseId(Long offlineCourseId) {
		this.offlineCourseId = offlineCourseId;
	}
	/**
	 * 获取：线下课程ID
	 */
	public Long getOfflineCourseId() {
		return offlineCourseId;
	}
	/**
	 * 设置：客服类型ID(type=customer)
	 */
	public void setSysDictId(Long sysDictId) {
		this.sysDictId = sysDictId;
	}
	/**
	 * 获取：客服类型ID(type=customer)
	 */
	public Long getSysDictId() {
		return sysDictId;
	}
	/**
	 * 设置：客服类型名称
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * 获取：客服类型名称
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * 设置：客服类型值(qq号，微信号)
	 */
	public void setCustomerVlaue(Integer customerVlaue) {
		this.customerVlaue = customerVlaue;
	}
	/**
	 * 获取：客服类型值(qq号，微信号)
	 */
	public Integer getCustomerVlaue() {
		return customerVlaue;
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
