package com.car.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "商品问答表")
public class CommodityQuestionFrom {

    @ApiModelProperty(value = "问题父类ID")
    private Long commodityQuestionParentId;

    @ApiModelProperty(value = "问题类型ID(商品ID/帖子ID)")
    private Long questionTypeId;

    @ApiModelProperty(value = "提问类型(0商品/1帖子)",required=true)
    private Integer questionType;

    @ApiModelProperty(value = "用户id",required=true)
    private Long userId;

    @ApiModelProperty(value = "问答人姓名")
    private String userName;

    @ApiModelProperty(value = "问答内容",required=true)
    private String replayContent;

    @ApiModelProperty(value = "问答人类型(0提问/1回答)",required=true)
    private Integer replayStatus;

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReplayContent() {
        return replayContent;
    }

    public void setReplayContent(String replayContent) {
        this.replayContent = replayContent;
    }

    public Integer getReplayStatus() {
        return replayStatus;
    }

    public void setReplayStatus(Integer replayStatus) {
        this.replayStatus = replayStatus;
    }

    public Long getCommodityQuestionParentId() {
        return commodityQuestionParentId;
    }

    public void setCommodityQuestionParentId(Long commodityQuestionParentId) {
        this.commodityQuestionParentId = commodityQuestionParentId;
    }

    public Long getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Long questionTypeId) {
        this.questionTypeId = questionTypeId;
    }
}
