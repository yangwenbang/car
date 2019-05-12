package com.car.modules.car.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 合作伙伴机构关联表
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-22 15:40:27
 */
@TableName("user_organization")
public class UserOrganizationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 面授机构ID
	 */
	private Long offlineOrganizationId;
	/**
	 * 二维码图片
	 */
	private String codePicture;
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
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：面授机构ID
	 */
	public void setOfflineOrganizationId(Long offlineOrganizationId) {
		this.offlineOrganizationId = offlineOrganizationId;
	}
	/**
	 * 获取：面授机构ID
	 */
	public Long getOfflineOrganizationId() {
		return offlineOrganizationId;
	}
	/**
	 * 设置：二维码图片
	 */
	public void setCodePicture(String codePicture) {
		this.codePicture = codePicture;
	}
	/**
	 * 获取：二维码图片
	 */
	public String getCodePicture() {
		return codePicture;
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
