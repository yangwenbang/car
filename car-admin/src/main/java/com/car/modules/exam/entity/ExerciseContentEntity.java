package com.car.modules.car.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.car.common.utils.json.MyDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-02-11 14:51:15
 */
@TableName("exercise_content")
public class ExerciseContentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 题目id
     */
    @TableId
    private Long id;
    /**
     * 题型id
     */
    @NotNull(message = "请选择题型")
    private Long exerciseTypeId;
    /**
     * 节id
     */
    private Long sectionId;
    /**
     * 题目内容
     */
    private String exerciseContent;
    /**
     * 候选项(多个用英文;隔开)
     */
    private String optionss;
    /**
     * 正确答案
     */
    private String rightAnswer;
    /**
     * 答案解析
     */
    private String answerAnalysis;
    /**
     * 分数
     */
    private Integer score;
    /**
     * 题目内容图片(url地址)
     */
    private String exerciseContentPicture;
    /**
     * 备注
     */
    private String remark;
    /**
     * 排序(小号排前序号*10)
     */
    private Integer seq;

    /**
     * 答案内容图片(url地址)
     */
    private String exerciseOptionPicture;
    /**
     * 答案内容图片(url地址)
     */
    private String exerciseAnswerPicture;

    /**
     * 创建时间
     */
    @JsonDeserialize(using = MyDateDeserializer.class)
    private Date createDate;
    /**
     * 更新时间
     */
    @JsonDeserialize(using = MyDateDeserializer.class)
    private Date updateTime;

    @TableField(exist = false)
    private String courseName;

    @TableField(exist = false)
    private String sectionName;

    @TableField(exist = false)
    private String chapterName;

    @TableField(exist = false)
    private String exerciseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public ExerciseContentEntity() {
    }

    /**
     * 设置：题目id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：题目id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：题型id
     */
    public void setExerciseTypeId(Long exerciseTypeId) {
        this.exerciseTypeId = exerciseTypeId;
    }

    /**
     * 获取：题型id
     */
    public Long getExerciseTypeId() {
        return exerciseTypeId;
    }

    /**
     * 设置：节id
     */
    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * 获取：节id
     */
    public Long getSectionId() {
        return sectionId;
    }

    /**
     * 设置：题目内容
     */
    public void setExerciseContent(String exerciseContent) {
        this.exerciseContent = exerciseContent;
    }

    /**
     * 设置：候选项(多个用英文;隔开)
     */
    public void setOptionss(String optionss) {
        this.optionss = optionss;
    }

    /**
     * 获取：候选项(多个用英文;隔开)
     */
    public String getOptionss() {
        return optionss;
    }

    /**
     * 获取：题目内容
     */
    public String getExerciseContent() {
        return exerciseContent;
    }

    /**
     * 设置：正确答案
     */
    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    /**
     * 获取：正确答案
     */
    public String getRightAnswer() {
        return rightAnswer;
    }

    /**
     * 设置：答案解析
     */
    public void setAnswerAnalysis(String answerAnalysis) {
        this.answerAnalysis = answerAnalysis;
    }

    /**
     * 获取：答案解析
     */
    public String getAnswerAnalysis() {
        return answerAnalysis;
    }

    /**
     * 设置：分数
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取：分数
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置：题目内容图片(url地址)
     */
    public void setExerciseContentPicture(String exerciseContentPicture) {
        this.exerciseContentPicture = exerciseContentPicture;
    }

    /**
     * 获取：题目内容图片(url地址)
     */
    public String getExerciseContentPicture() {
        return exerciseContentPicture;
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
     * 设置：答案内容图片(url地址)
     */
    public void setExerciseAnswerPicture(String exerciseAnswerPicture) {
        this.exerciseAnswerPicture = exerciseAnswerPicture;
    }

    /**
     * 获取：答案内容图片(url地址)
     */
    public String getExerciseAnswerPicture() {
        return exerciseAnswerPicture;
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

    public String getExerciseOptionPicture() {
        return exerciseOptionPicture;
    }

    public void setExerciseOptionPicture(String exerciseOptionPicture) {
        this.exerciseOptionPicture = exerciseOptionPicture;
    }
}
