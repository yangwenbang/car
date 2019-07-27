package com.car.form;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class PublishPostForm {

    @ApiModelProperty(value = "发布标题",required=true)
    @NotBlank(message = "发布标题不能为空")
    private String publishTitle;

    @ApiModelProperty(value = "发布内容",required=true)
    @NotBlank(message = "发布内容不能为空")
    private String publishContent;

    @ApiModelProperty(value = "发布图片，多个用逗号隔开")
    private String publishPicture;

    @ApiModelProperty(value = "帖子发布地址(省，市，区)")
    private String publishAddress;

    @ApiModelProperty(value = "发布人",required=true)
    @NotBlank(message = "发布人不能为空")
    private Long publishUserId;

    @ApiModelProperty(value = "详情地址")
    private String detailAddress;
    
    @ApiModelProperty(value = "经度")
	private String longitude;
	
    @ApiModelProperty(value = "纬度")
	private String latitude;

    public String getPublishTitle() {
        return publishTitle == null ? "" : publishTitle;
    }

    public void setPublishTitle(String publishTitle) {
        this.publishTitle = publishTitle;
    }

    public String getPublishContent() {
        return publishContent == null ? "" : publishContent;
    }

    public void setPublishContent(String publishContent) {
        this.publishContent = publishContent;
    }

    public String getPublishPicture() {
        return publishPicture == null ? "" : publishPicture;
    }

    public void setPublishPicture(String publishPicture) {
        this.publishPicture = publishPicture;
    }

    public String getPublishAddress() {
        return publishAddress == null ? "" : publishAddress;
    }

    public void setPublishAddress(String publishAddress) {
        this.publishAddress = publishAddress;
    }

    public Long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId == null ? 0 : publishUserId;
    }

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
}
