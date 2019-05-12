package com.car.modules.car.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-25 00:01:50
 */
@TableName("section")
public class SectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 节id
     */
    @TableId
    private Long id;
    /**
     * 章id
     */
    private Long chapterId;
    /**
     * 节名称
     */
    @NotBlank(message = "请输入节名称")
    private String sectionName;
    /**
     * 节长度，视频记录时长(分钟)，试卷记录题数，资料记录字数（估算）
     */
    private Integer timeLength;

    private Integer exerciseCount;

    /**
     * 课件类型：(0视频；1资料，2试卷)
     */
    private Integer sectionType;
    /**
     * 课件内容网址
     */
    private String sectionUrl;
    /**
     * 资料内容(html)
     */
    private String sectionContent;
    /**
     * 备注
     */
    private String remark;
    /**
     * 排序(小号排前)
     */
    private Integer seq;
    /**
     * 是否免费(0不免费/1免费)
     */
    private Integer free;
    /**
     * 试卷抬头
     */
    private String carTitle;
    /**
     * 题型模板
     */
    private Integer exerciseModelId;
    /**
     * 讲义
     */
    private String handout;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 设置：节id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：节id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：章id
     */
    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    /**
     * 获取：章id
     */
    public Long getChapterId() {
        return chapterId;
    }

    /**
     * 设置：节名称
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    /**
     * 获取：节名称
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * 设置：节长度，视频记录时长(分钟)，试卷记录题数，资料记录字数（估算）
     */
    public void setTimeLength(Integer timeLength) {
        this.timeLength = timeLength;
    }

    /**
     * 获取：节长度，视频记录时长(分钟)，试卷记录题数，资料记录字数（估算）
     */
    public Integer getTimeLength() {
        return timeLength;
    }

    /**
     * 设置：课件类型：(0视频；1资料，2试卷)
     */
    public void setSectionType(Integer sectionType) {
        this.sectionType = sectionType;
    }

    /**
     * 获取：课件类型：(0视频；1资料，2试卷)
     */
    public Integer getSectionType() {
        return sectionType;
    }

    /**
     * 设置：课件内容网址
     */
    public void setSectionUrl(String sectionUrl) {
        this.sectionUrl = sectionUrl;
    }

    /**
     * 获取：课件内容网址
     */
    public String getSectionUrl() {
        return sectionUrl;
    }

    /**
     * 设置：资料内容(html)
     */
    public void setSectionContent(String sectionContent) {
        this.sectionContent = sectionContent;
    }

    /**
     * 获取：资料内容(html)
     */
    public String getSectionContent() {
        return sectionContent;
    }

    /**
     * 设置：备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置：排序(小号排前)
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取：排序(小号排前)
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置：是否免费(0不免费/1免费)
     */
    public void setFree(Integer free) {
        this.free = free;
    }

    /**
     * 获取：是否免费(0不免费/1免费)
     */
    public Integer getFree() {
        return free;
    }

    /**
     * 设置：试卷抬头
     */
    public void setcarTitle(String carTitle) {
        this.carTitle = carTitle;
    }

    /**
     * 获取：试卷抬头
     */
    public String getcarTitle() {
        return carTitle;
    }


    public Integer getExerciseModelId() {
        return exerciseModelId;
    }

    public void setExerciseModelId(Integer exerciseModelId) {
        this.exerciseModelId = exerciseModelId;
    }

    /**
     * 设置：讲义
     */
    public void setHandout(String handout) {
        this.handout = handout;
    }

    /**
     * 获取：讲义
     */
    public String getHandout() {
        return handout;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public Integer getExerciseCount() {
        return exerciseCount;
    }

    public void setExerciseCount(Integer exerciseCount) {
        this.exerciseCount = exerciseCount;
    }


}
