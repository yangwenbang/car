package com.car.modules.car.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-23 00:54:34
 */
@TableName("subject")
public class SubjectEntity extends Model<SubjectEntity> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 学科id
     */
    @TableId
    private Long id;
    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 分类id
     */
    private Long categoryId;
    /**
     * 学科名称
     */
    @NotNull
    private String subjectName;
    /**
     * 学科描述
     */
    private String subjectDesc;
    /**
     * 图片
     */
    private String subjectPicture;
    /**
     * 是否有效
     */
    @NotNull
    private Integer effective;
    /**
     * 排序
     */
    private Integer seq;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 设置：学科id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：学科id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：项目id
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取：项目id
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * 设置：分类id
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取：分类id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置：学科名称
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * 获取：学科名称
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * 设置：学科描述
     */
    public void setSubjectDesc(String subjectDesc) {
        this.subjectDesc = subjectDesc;
    }

    /**
     * 获取：学科描述
     */
    public String getSubjectDesc() {
        return subjectDesc;
    }

    /**
     * 设置：图片
     */
    public void setSubjectPicture(String subjectPicture) {
        this.subjectPicture = subjectPicture;
    }

    /**
     * 获取：图片
     */
    public String getSubjectPicture() {
        return subjectPicture;
    }

    /**
     * 设置：是否有效
     */
    public void setEffective(Integer effective) {
        this.effective = effective;
    }

    /**
     * 获取：是否有效
     */
    public Integer getEffective() {
        return effective;
    }

    /**
     * 设置：排序
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取：排序
     */
    public Integer getSeq() {
        return seq;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * 设置：创建时间
     */

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

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
