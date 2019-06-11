package com.car.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class CommodityQuestionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "问答父id",required=true)
    private Long parentId;

    @ApiModelProperty(value = "问答id",required=true)
    private Long commodityQuestionId;

    @ApiModelProperty(value = "提问类型(0商品/1帖子)",required=true)
    private Integer questionType;

    @ApiModelProperty(value = "问答人姓名")
    private String userName;

    @ApiModelProperty(value = "问答内容",required=true)
    private String replayContent;

    @ApiModelProperty(value = "问答时间",required=true)
    private String replayDate;

    @ApiModelProperty(value = "问答时间")
    private Integer replayStatus;

    private List<CommodityQuestionChildDTO> commodityQuestionChildDTO;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getCommodityQuestionId() {
        return commodityQuestionId;
    }

    public void setCommodityQuestionId(Long commodityQuestionId) {
        this.commodityQuestionId = commodityQuestionId;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
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

    public String getReplayDate() {
        return replayDate;
    }

    public void setReplayDate(String replayDate) {
        this.replayDate = replayDate;
    }

    public Integer getReplayStatus() {
        return replayStatus;
    }

    public void setReplayStatus(Integer replayStatus) {
        this.replayStatus = replayStatus;
    }

    public List<CommodityQuestionChildDTO> getCommodityQuestionChildDTO() {
        return commodityQuestionChildDTO;
    }

    public void setCommodityQuestionChildDTO(List<CommodityQuestionChildDTO> commodityQuestionChildDTO) {
        this.commodityQuestionChildDTO = commodityQuestionChildDTO;
    }
}
