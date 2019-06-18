package com.car.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-19 23:07:55
 */
public class PublishPost implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 帖子ID
	 */
	private Long id;
	/**
	 * 发布标题
	 */
	private String publishTitle;
	/**
	 * 发布内容
	 */
	private String publishContent;
	/**
	 * 发布图片，多个用逗号隔开
	 */
	private String publishPicture;
	/**
	 * 发布地址
	 */
	private String publishAddress;
	/**
	 * 发布人
	 */
	private Long publishUserId;
	/**
	 * 发布时间
	 */
	private Date publishTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;

	private String publishUserName;

	private String publishUserPicture;

	/**
	 * 设置：帖子ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：帖子ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：发布标题
	 */
	public void setPublishTitle(String publishTitle) {
		this.publishTitle = publishTitle;
	}
	/**
	 * 获取：发布标题
	 */
	public String getPublishTitle() {
		return publishTitle;
	}
	/**
	 * 设置：发布内容
	 */
	public void setPublishContent(String publishContent) {
		this.publishContent = publishContent;
	}
	/**
	 * 获取：发布内容
	 */
	public String getPublishContent() {
		return publishContent;
	}
	/**
	 * 设置：发布图片，多个用逗号隔开
	 */
	public void setPublishPicture(String publishPicture) {
		this.publishPicture = publishPicture;
	}
	/**
	 * 获取：发布图片，多个用逗号隔开
	 */
	public String getPublishPicture() {
		return publishPicture;
	}
	/**
	 * 设置：发布地址
	 */
	public void setPublishAddress(String publishAddress) {
		this.publishAddress = publishAddress;
	}
	/**
	 * 获取：发布地址
	 */
	public String getPublishAddress() {
		return publishAddress;
	}
	/**
	 * 设置：发布人
	 */
	public void setPublishUserId(Long publishUserId) {
		this.publishUserId = publishUserId;
	}
	/**
	 * 获取：发布人
	 */
	public Long getPublishUserId() {
		return publishUserId;
	}
	/**
	 * 设置：发布时间
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getPublishTime() {
		return publishTime;
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

	public String getPublishUserName() {
		return publishUserName;
	}

	public void setPublishUserName(String publishUserName) {
		this.publishUserName = publishUserName;
	}

	public String getPublishUserPicture() {
		return publishUserPicture;
	}

	public void setPublishUserPicture(String publishUserPicture) {
		this.publishUserPicture = publishUserPicture;
	}
}
