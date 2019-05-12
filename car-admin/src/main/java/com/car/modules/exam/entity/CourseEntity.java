package com.car.modules.car.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-20 20:07:58
 */
@TableName("course")
public class CourseEntity extends Model<CourseEntity> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 课程id
     */
    @TableId
    private Long id;
    /**
     * 课程名称
     */
    @NotBlank(message = "请选择课程名称")
    private String courseName;
    /**
     * 课程类型(0资料/1视频/2题库/3公开课/4每日一练)
     */
    @NotNull(message = "请选择课程类型")
    private Integer courseType;
    /**
     * 课程图片网址
     */
    private String pictureUrl;
    /**
     * 视频地址
     */
    private String courseUrl;
    /**
     * 一句话
     */
    private String oneWord;
    /**
     * 课程介绍
     */
    private String introduce;
    /**
     * 教师id
     */
    private Long teacherId;
    /**
     * 教师名称
     */
    private String teacherName;
    /**
     * 课时数
     */
    @Range(max = 10000, min = 0, message = "请选择有效课时数0到10000")
    private Integer courseCount;
    /**
     * 价格
     */
    @Range(max = 1000000, min = 0, message = "请选择有效价格0到1000000")
    private BigDecimal price;
    /**
     * 折扣
     */
    @Range(max = 10000, min = 0, message = "请选择有效折扣0到10000")
    private BigDecimal discount;
    /**
     * 项目id
     */
    @NotNull
    private Long projectId;
    /**
     * 分类id
     */
    @NotNull
    private Long categoryId;
    /**
     * 学科id
     */
    @NotNull
    private Long subjectId;
    /**
     * 有效否
     */
    @NotNull(message = "请选择有效性")
    private Integer effective;
    /**
     * 发布时间
     */
    @NotNull(message = "请选择发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date replayDate;
    /**
     * 发布人
     */
    @NotNull
    private String replayUsername;
    /**
     * 排序(大号在前)
     */
    private Integer seq;
    /**
     * 项目名称
     */
    @NotBlank(message = "请选择项目名称")
    private String projectName;
    /**
     * 分类名称
     */
    @NotBlank(message = "请选择分类名称")
    private String categoryName;
    /**
     * 学科名称
     */
    @NotBlank(message = "请选择学科名称")
    private String subjectName;
    /**
     * 名课程推荐(0不是/1是)
     */
    private Integer isFamous;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 设置：课程id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：课程id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：课程名称
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * 获取：课程名称
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 设置：课程类型(0资料/1视频/2题库/3公开课/4每日一练)
     */
    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    /**
     * 获取：课程类型(0资料/1视频/2题库/3公开课/4每日一练)
     */
    public Integer getCourseType() {
        return courseType;
    }

    /**
     * 设置：课程图片网址
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    /**
     * 获取：课程图片网址
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * 设置：一句话
     */
    public void setOneWord(String oneWord) {
        this.oneWord = oneWord;
    }

    /**
     * 获取：一句话
     */
    public String getOneWord() {
        return oneWord;
    }

    /**
     * 设置：课程介绍
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    /**
     * 获取：课程介绍
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 设置：教师id
     */
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * 获取：教师id
     */
    public Long getTeacherId() {
        return teacherId;
    }

    /**
     * 设置：教师名称
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * 获取：教师名称
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * 设置：课时数
     */
    public void setCourseCount(Integer courseCount) {
        this.courseCount = courseCount;
    }

    /**
     * 获取：课时数
     */
    public Integer getCourseCount() {
        return courseCount;
    }

    /**
     * 设置：价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取：价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置：折扣
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * 获取：折扣
     */
    public BigDecimal getDiscount() {
        return discount;
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
     * 设置：学科id
     */
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * 获取：学科id
     */
    public Long getSubjectId() {
        return subjectId;
    }

    /**
     * 设置：有效否
     */
    public void setEffective(Integer effective) {
        this.effective = effective;
    }

    /**
     * 获取：有效否
     */
    public Integer getEffective() {
        return effective;
    }

    /**
     * 设置：发布时间
     */
    public void setReplayDate(Date replayDate) {
        this.replayDate = replayDate;
    }

    /**
     * 获取：发布时间
     */
    public Date getReplayDate() {
        return replayDate;
    }

    /**
     * 设置：发布人
     */
    public void setReplayUsername(String replayUsername) {
        this.replayUsername = replayUsername;
    }

    /**
     * 获取：发布人
     */
    public String getReplayUsername() {
        return replayUsername;
    }

    /**
     * 设置：排序(大号在前)
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取：排序(大号在前)
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置：项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取：项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置：分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 获取：分类名称
     */
    public String getCategoryName() {
        return categoryName;
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
     * 设置：名课程推荐(0不是/1是)
     */
    public void setIsFamous(Integer isFamous) {
        this.isFamous = isFamous;
    }

    /**
     * 获取：名课程推荐(0不是/1是)
     */
    public Integer getIsFamous() {
        return isFamous;
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

    public String getCourseUrl() {
        return courseUrl;
    }

    public void setCourseUrl(String courseUrl) {
        this.courseUrl = courseUrl;
    }


    @Override
    protected Serializable pkVal() {
        return id;
    }
}
