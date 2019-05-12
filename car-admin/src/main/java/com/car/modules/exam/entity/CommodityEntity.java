package com.car.modules.car.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-14 15:46:53
 */
@TableName("commodity")
public class CommodityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 项目ID
	 */
	private Long projectId;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 商品名称
	 */
	private String commodityName;
	/**
	 * 商品图片，多个用逗号隔开
	 */
	private String pictureUrl;
	/**
	 * 一句话
	 */
	private String oneWord;
	/**
	 * 介绍，富文本
	 */
	private String introduce;
	/**
	 * 介绍网址
	 */
	private String introduceUrl;
	/**
	 * 学币
	 */
	private BigDecimal coin;
	/**
	 * 有效否(0失效/1有效)
	 */
	private Integer effective;
	/**
	 * 排序(大号在前)
	 */
	private Integer seq;
	/**
	 * 发布时间
	 */
	private Date replayDate;
	/**
	 * 发布人
	 */
	private String replayUsername;
	/**
	 * 修改时间
	 */
	private Date updateTime;

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
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
	 * 设置：商品名称
	 */
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	/**
	 * 获取：商品名称
	 */
	public String getCommodityName() {
		return commodityName;
	}
	/**
	 * 设置：商品图片，多个用逗号隔开
	 */
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	/**
	 * 获取：商品图片，多个用逗号隔开
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
	 * 设置：介绍，富文本
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	/**
	 * 获取：介绍，富文本
	 */
	public String getIntroduce() {
		return introduce;
	}
	/**
	 * 设置：介绍网址
	 */
	public void setIntroduceUrl(String introduceUrl) {
		this.introduceUrl = introduceUrl;
	}
	/**
	 * 获取：介绍网址
	 */
	public String getIntroduceUrl() {
		return introduceUrl;
	}
	/**
	 * 设置：学币
	 */
	public void setCoin(BigDecimal coin) {
		this.coin = coin;
	}
	/**
	 * 获取：学币
	 */
	public BigDecimal getCoin() {
		return coin;
	}
	/**
	 * 设置：有效否(0失效/1有效)
	 */
	public void setEffective(Integer effective) {
		this.effective = effective;
	}
	/**
	 * 获取：有效否(0失效/1有效)
	 */
	public Integer getEffective() {
		return effective;
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
}
