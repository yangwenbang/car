package com.car.modules.car.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-13 11:18:40
 */
@TableName("msg_type")
public class MsgTypeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Long id;
    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 分类名称
     */
    private String typeName;
    /**
     * 分类描述
     */
    private String typeDesc;
    /**
     * 有效否(0：无效;1：有效)
     */
    private Integer effective;


    private Integer seq;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private String projectName;


    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
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
     * 设置：分类名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 获取：分类名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置：分类描述
     */
    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    /**
     * 获取：分类描述
     */
    public String getTypeDesc() {
        return typeDesc;
    }

    /**
     * 设置：有效否(0：无效;1：有效)
     */
    public void setEffective(Integer effective) {
        this.effective = effective;
    }

    /**
     * 获取：有效否(0：无效;1：有效)
     */
    public Integer getEffective() {
        return effective;
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
     * 设置：修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
