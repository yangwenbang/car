package com.car.modules.car.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-11 20:54:55
 */
@TableName("new_msg")
public class NewMsgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 资讯id
	 */
	@TableId
	private Long id;
	/**
	 * 项目ID
	 */
	private Long projectId;
	/**
	 * 资讯分类ID
	 */
	private Long msgTypeId;
	/**
	 * 资讯名称
	 */
	private String msgName;
	/**
	 * 一句话
	 */
	private String oneWord;
	/**
	 * 内容(html)
	 */
	private String msgContent;
	/**
	 * 内容网址
	 */
	private String msgContentUrl;
	/**
	 * 发布时间
	 */
	private Date publishDate;
	/**
	 * 发布人
	 */
	private String publishUsername;
	/**
	 * 有效否(0：无效;1：有效)
	 */
	private Integer effective;
	/**
	 * 排序号(大号排前 序号*10)
	 */
	private Integer seq;
	/**
	 * 重要级别
	 */
	private Integer importLevel;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 资讯分类名称
	 */
	private String msgTypeName;

	/**
	 * 设置：资讯id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：资讯id
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
	 * 设置：资讯分类ID
	 */
	public void setMsgTypeId(Long msgTypeId) {
		this.msgTypeId = msgTypeId;
	}
	/**
	 * 获取：资讯分类ID
	 */
	public Long getMsgTypeId() {
		return msgTypeId;
	}
	/**
	 * 设置：资讯名称
	 */
	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}
	/**
	 * 获取：资讯名称
	 */
	public String getMsgName() {
		return msgName;
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
	 * 设置：内容(html)
	 */
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	/**
	 * 获取：内容(html)
	 */
	public String getMsgContent() {
		return msgContent;
	}
	/**
	 * 设置：内容网址
	 */
	public void setMsgContentUrl(String msgContentUrl) {
		this.msgContentUrl = msgContentUrl;
	}
	/**
	 * 获取：内容网址
	 */
	public String getMsgContentUrl() {
		return msgContentUrl;
	}
	/**
	 * 设置：发布时间
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getPublishDate() {
		return publishDate;
	}
	/**
	 * 设置：发布人
	 */
	public void setPublishUsername(String publishUsername) {
		this.publishUsername = publishUsername;
	}
	/**
	 * 获取：发布人
	 */
	public String getPublishUsername() {
		return publishUsername;
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
	 * 设置：排序号(大号排前 序号*10)
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	/**
	 * 获取：排序号(大号排前 序号*10)
	 */
	public Integer getSeq() {
		return seq;
	}
	/**
	 * 设置：重要级别
	 */
	public void setImportLevel(Integer importLevel) {
		this.importLevel = importLevel;
	}
	/**
	 * 获取：重要级别
	 */
	public Integer getImportLevel() {
		return importLevel;
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
	 * 设置：资讯分类名称
	 */
	public void setMsgTypeName(String msgTypeName) {
		this.msgTypeName = msgTypeName;
	}
	/**
	 * 获取：资讯分类名称
	 */
	public String getMsgTypeName() {
		return msgTypeName;
	}
}
