package com.car.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("用户消息对象")
public class SysInfoVO implements Serializable  {

    @ApiModelProperty(value = "消息ID")
    private Long sysInfoId;

    @ApiModelProperty(value = "项目id")
    private Long projectId;

    @ApiModelProperty(value = "消息类型（0付款/1系统）")
    private Integer infoType;

    @ApiModelProperty(value = "消息产生时间")
    private String produceDate;

    @ApiModelProperty(value = "产生人")
    private String produceUsername;

    @ApiModelProperty(value = "消息内容")
    private String infoContent;

    @ApiModelProperty(value = "阅读状态(0未阅读/1已阅读)")
    private Integer readStatus;

    public Long getSysInfoId() {
        return sysInfoId;
    }

    public void setSysInfoId(Long sysInfoId) {
        this.sysInfoId = sysInfoId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getInfoType() {
        return infoType;
    }

    public void setInfoType(Integer infoType) {
        this.infoType = infoType;
    }

    public String getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate;
    }

    public String getProduceUsername() {
        return produceUsername;
    }

    public void setProduceUsername(String produceUsername) {
        this.produceUsername = produceUsername;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }
}
