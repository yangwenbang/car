package com.car.form;

public class PublishPostForm {
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
