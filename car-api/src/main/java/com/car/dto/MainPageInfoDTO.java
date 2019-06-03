package com.car.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class MainPageInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "发布帖子id")
    private Long publishPostId;

    @ApiModelProperty(value = "发布帖子标题")
    private String publishTitle;

    @ApiModelProperty(value = "发布帖子内容")
    private String publishContent;

    @ApiModelProperty(value = "发布帖子图片，多个用逗号隔开")
    private String publishPicture;

    @ApiModelProperty(value = "发布人")
    private Long publishUserId;

    private List<CommodityQuestionDTO> commodityQuestionList;

    public Long getPublishPostId() {
        return publishPostId;
    }

    public void setPublishPostId(Long publishPostId) {
        this.publishPostId = publishPostId;
    }

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

    public Long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId;
    }

    public List<CommodityQuestionDTO> getCommodityQuestionList() {
        return commodityQuestionList;
    }

    public void setCommodityQuestionList(List<CommodityQuestionDTO> commodityQuestionList) {
        this.commodityQuestionList = commodityQuestionList;
    }
}
