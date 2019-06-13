package com.car.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-19 23:07:55
 */
@ApiModel("帖子对象")
public class PublishPostVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "帖子ID")
	private Long publishPostId;

	@ApiModelProperty(value = "发布标题")
	private String publishTitle;

	@ApiModelProperty(value = "发布内容")
	private String publishContent;

	@ApiModelProperty(value = "发布图片，多个用逗号隔开")
	private String publishPicture;

	@ApiModelProperty(value = "发布地址")
	private String publishAddress;

	@ApiModelProperty(value = "发布时间")
	private Date publishTime;

	public void setPublishTitle(String publishTitle) {
		this.publishTitle = publishTitle;
	}

	public String getPublishTitle() {
		return publishTitle;
	}

	public void setPublishContent(String publishContent) {
		this.publishContent = publishContent;
	}

	public String getPublishContent() {
		return publishContent;
	}

	public void setPublishPicture(String publishPicture) {
		this.publishPicture = publishPicture;
	}

	public String getPublishPicture() {
		return publishPicture;
	}

	public void setPublishAddress(String publishAddress) {
		this.publishAddress = publishAddress;
	}

	public String getPublishAddress() {
		return publishAddress;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public Long getPublishPostId() {
		return publishPostId;
	}

	public void setPublishPostId(Long publishPostId) {
		this.publishPostId = publishPostId;
	}
}
