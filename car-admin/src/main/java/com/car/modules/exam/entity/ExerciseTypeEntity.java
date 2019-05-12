package com.car.modules.car.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-02-11 14:51:15
 */
@TableName("exercise_type")
public class ExerciseTypeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 题型id
     */
    @TableId
    private Long id;
    /**
     * 题型名称
     */
    private String exerciseName;
    /**
     * 题型说明
     */
    private String description;
    /**
     * 题型(0单选/1多选/2问答)
     */
    private Integer exerciseType;
    /**
     * 备注
     */
    private String remark;


    /**
     * 题型模板
     */
    private long exerciseModelId;

    @TableField(exist = false)
    private String exerciseModel;
    /**
     * 排序(小号排前序号*10)
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
     * 设置：题型id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：题型id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：题型名称
     */
    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    /**
     * 获取：题型名称
     */
    public String getExerciseName() {
        return exerciseName;
    }

    /**
     * 设置：题型说明
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取：题型说明
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置：题型(0单选/1多选/2问答)
     */
    public void setExerciseType(Integer exerciseType) {
        this.exerciseType = exerciseType;
    }

    /**
     * 获取：题型(0单选/1多选/2问答)
     */
    public Integer getExerciseType() {
        return exerciseType;
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
     * 设置：题型模板
     */
    public void setExerciseModel(String exerciseModel) {
        this.exerciseModel = exerciseModel;
    }

    /**
     * 获取：题型模板
     */
    public String getExerciseModel() {
        return exerciseModel;
    }

    /**
     * 设置：排序(小号排前序号*10)
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取：排序(小号排前序号*10)
     */
    public Integer getSeq() {
        return seq;
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

    public long getExerciseModelId() {
        return exerciseModelId;
    }

    public void setExerciseModelId(long exerciseModelId) {
        this.exerciseModelId = exerciseModelId;
    }
}
