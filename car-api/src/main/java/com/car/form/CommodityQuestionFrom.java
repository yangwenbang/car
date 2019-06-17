package com.car.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;


@ApiModel(value = "商品问答表")
public class CommodityQuestionFrom {

    @ApiModelProperty(value = "问答父类ID,如果是第一次提问父ID为-1，其他不管提问还是回答父id为第一次提问id")
    @NotBlank(message = "问答父类ID为空")
    private Long commodityQuestionParentId;

    @ApiModelProperty(value = "问题类型ID(商品ID/帖子ID)",required=true)
    @NotBlank(message = "问题类型ID为空")
    private Long questionTypeId;

    @ApiModelProperty(value = "提问类型(0商品/1帖子)",required=true)
    @NotBlank(message = "提问类型ID为空")
    private Integer questionType;

    @ApiModelProperty(value = "用户id",required=true)
    @NotBlank(message = "用户id为空")
    private Long userId;

    @ApiModelProperty(value = "问答人姓名")
    private String userName;

    @ApiModelProperty(value = "问答内容",required=true)
    @NotBlank(message = "问答内容为空")
    private String replayContent;

    @ApiModelProperty(value = "问答人类型(0提问/1回答)",required=true)
    @NotBlank(message = "问答人类型为空")
    private Integer replayStatus;

    @ApiModelProperty(value = "用户头像地址")
    private String userHead;

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
        return userName == null ? "" : userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReplayContent() {
        return replayContent == null ? "" : replayContent;
    }

    public void setReplayContent(String replayContent) {
        this.replayContent = replayContent;
    }

    public Integer getReplayStatus() {
        return replayStatus == null ? 0 : replayStatus;
    }

    public void setReplayStatus(Integer replayStatus) {
        this.replayStatus = replayStatus;
    }

    public Long getCommodityQuestionParentId() {
        return commodityQuestionParentId == null ? -1 : commodityQuestionParentId;
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

    public String getUserHead() {
        return userHead == null ? "" : userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }
}
