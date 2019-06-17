package com.car.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-27 01:05:41
 */
public class CommodityQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 问题id
	 */
	private Long id;
	/**
	 * 问题父类ID
	 */
	private Long parentId;
	/**
	 * 问题类型ID(商品ID/帖子ID)
	 */
	private Long questionTypeId;
	/**
	 * 提问类型(0商品/1帖子)
	 */
	private Integer questionType;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 问答人姓名
	 */
	private String userName;
	/**
	 * 问答内容
	 */
	private String replayContent;
	/**
	 * 问答时间
	 */
	private Date replayDate;
	/**
	 * 问答人类型(0提问/1回答)
	 */
	private Integer replayStatus;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;

	private String userHead;

	/**
	 * 设置：商品ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：商品ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：提问类型(0商品/1帖子)
	 */
	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}
	/**
	 * 获取：提问类型(0商品/1帖子)
	 */
	public Integer getQuestionType() {
		return questionType;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：问答人姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：问答人姓名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：问答内容
	 */
	public void setReplayContent(String replayContent) {
		this.replayContent = replayContent;
	}
	/**
	 * 获取：问答内容
	 */
	public String getReplayContent() {
		return replayContent;
	}
	/**
	 * 设置：问答时间
	 */
	public void setReplayDate(Date replayDate) {
		this.replayDate = replayDate;
	}
	/**
	 * 获取：问答时间
	 */
	public Date getReplayDate() {
		return replayDate;
	}
	/**
	 * 设置：问答人类型(0提问/1回答)
	 */
	public void setReplayStatus(Integer replayStatus) {
		this.replayStatus = replayStatus;
	}
	/**
	 * 获取：问答人类型(0提问/1回答)
	 */
	public Integer getReplayStatus() {
		return replayStatus;
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

	public Long getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(Long questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		if(parentId == null){
			parentId = -1L;
		}
		this.parentId = parentId;
	}

	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}
}
