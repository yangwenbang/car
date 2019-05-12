package com.car.modules.car.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-25 00:01:28
 */
@TableName("chapter")
public class ChapterEntity extends Model<ChapterEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 章id
	 */
	@TableId
	private Long id;
	/**
	 * 课程id
	 */
	@NotNull(message = "课程不能为空")
	private Long courseId;
	/**
	 * 章名称
	 */
	@NotNull(message = "课章名称不能为空")
	private String chapterName;
	/**
	 * 说明
	 */
	private String description;
	/**
	 * 排序(大号排前)
	 */
	@Range(max=1000000,min=0,message="请选择有效排序0到1000000")
	private Integer seq;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 设置：章id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：章id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：课程id
	 */
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：课程id
	 */
	public Long getCourseId() {
		return courseId;
	}
	/**
	 * 设置：章名称
	 */
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	/**
	 * 获取：章名称
	 */
	public String getChapterName() {
		return chapterName;
	}
	/**
	 * 设置：说明
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：说明
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：排序(大号排前)
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	/**
	 * 获取：排序(大号排前)
	 */
	public Integer getSeq() {
		return seq;
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

	@Override
	protected Serializable pkVal() {
		return id;
	}
}
