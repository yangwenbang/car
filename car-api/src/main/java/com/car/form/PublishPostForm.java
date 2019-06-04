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

    @ApiModelProperty(value = "发布地址")
    private String publishAddress;

    @ApiModelProperty(value = "发布人",required=true)
    @NotBlank(message = "发布人不能为空")
    private Long publishUserId;

    public String getPublishTitle() {
        return publishTitle;
    }

    public void setPublishTitle(String publishTitle) {
        this.publishTitle = publishTitle;
    }

    public String getPublishContent() {
        return publishContent;
    }

    public void setPublishContent(String publishContent) {
        this.publishContent = publishContent;
    }

    public String getPublishPicture() {
        return publishPicture;
    }

    public void setPublishPicture(String publishPicture) {
        this.publishPicture = publishPicture;
    }

    public String getPublishAddress() {
        return publishAddress;
    }

    public void setPublishAddress(String publishAddress) {
        this.publishAddress = publishAddress;
    }

    public Long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId;
    }
}
