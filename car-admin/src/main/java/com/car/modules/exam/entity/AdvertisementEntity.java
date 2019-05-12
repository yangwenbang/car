package com.car.modules.car.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-13 14:59:04
 */
@TableName("advertisement")
public class AdvertisementEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 图片推荐id
     */
    @TableId
    private Long id;
    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 图片网址
     */
    private String pictureUrl;
    /**
     * 图片网址
     */
    private Integer pictureType;
    /**
     * 操作类型（0不操作2打开网址）
     */
    private Integer operateType;
    /**
     * 操作网址（2时打开的网址）
     */
    private String operateUrl;
    /**
     * 排序号(大号排前)
     */
    private Integer seq;
    /**
     * 有效否(0无效/1有效)
     */
    private Integer effective;
    /**
     * 创建时间
     */
    private Date createDate;

    private Date updateTime;

    /**
     * 设置：图片推荐id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：图片推荐id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：项目ID
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取：项目ID
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * 设置：图片网址
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    /**
     * 获取：图片网址
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * 设置：操作类型（0不操作2打开网址）
     */
    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    /**
     * 获取：操作类型（0不操作2打开网址）
     */
    public Integer getOperateType() {
        return operateType;
    }

    /**
     * 设置：操作网址（2时打开的网址）
     */
    public void setOperateUrl(String operateUrl) {
        this.operateUrl = operateUrl;
    }

    /**
     * 获取：操作网址（2时打开的网址）
     */
    public String getOperateUrl() {
        return operateUrl;
    }

    /**
     * 设置：排序号(大号排前)
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取：排序号(大号排前)
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置：有效否(0无效/1有效)
     */
    public void setEffective(Integer effective) {
        this.effective = effective;
    }

    /**
     * 获取：有效否(0无效/1有效)
     */
    public Integer getEffective() {
        return effective;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    public Integer getPictureType() {
        return pictureType;
    }

    public void setPictureType(Integer pictureType) {
        this.pictureType = pictureType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
