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
 * @date 2019-03-25 21:51:02
 */
@TableName("user_introduce")
public class UserIntroduceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 合作伙伴用户id
	 */
	private Long userId;
	/**
	 * 机构ID
	 */
	private Long offlineOrganizationId;
	/**
	 * 机构码
	 */
	private String organizationCode;
	/**
	 * 
	 */
	private String organizationName;
	/**
	 * 
	 */
	private String organizationPicture;
	/**
	 * 新用户微信openid
	 */
	private String openid;
	/**
	 * 新用户确认时间
	 */
	private Date confirmDate;

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
	 * 设置：合作伙伴用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：合作伙伴用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：机构ID
	 */
	public void setOfflineOrganizationId(Long offlineOrganizationId) {
		this.offlineOrganizationId = offlineOrganizationId;
	}
	/**
	 * 获取：机构ID
	 */
	public Long getOfflineOrganizationId() {
		return offlineOrganizationId;
	}
	/**
	 * 设置：机构码
	 */
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	/**
	 * 获取：机构码
	 */
	public String getOrganizationCode() {
		return organizationCode;
	}
	/**
	 * 设置：
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	/**
	 * 获取：
	 */
	public String getOrganizationName() {
		return organizationName;
	}
	/**
	 * 设置：
	 */
	public void setOrganizationPicture(String organizationPicture) {
		this.organizationPicture = organizationPicture;
	}
	/**
	 * 获取：
	 */
	public String getOrganizationPicture() {
		return organizationPicture;
	}
	/**
	 * 设置：新用户微信openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * 获取：新用户微信openid
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * 设置：新用户确认时间
	 */
	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}
	/**
	 * 获取：新用户确认时间
	 */
	public Date getConfirmDate() {
		return confirmDate;
	}
}
