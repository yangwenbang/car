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
 * @date 2019-03-15 18:14:16
 */
@TableName("province")
public class ProvinceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 省份名称
	 */
	private String provinceName;
	/**
	 * 公司地址
	 */
	private String companyAddress;
	/**
	 * 联系方式
	 */
	private String contactWay;
	/**
	 * 是否有效(0:无效，1:有效)
	 */
	private Integer effective;
	/**
	 * 创建时间
	 */
	private Date createTime;

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
	 * 设置：省份名称
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	/**
	 * 获取：省份名称
	 */
	public String getProvinceName() {
		return provinceName;
	}
	/**
	 * 设置：公司地址
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	/**
	 * 获取：公司地址
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}
	/**
	 * 设置：联系方式
	 */
	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}
	/**
	 * 获取：联系方式
	 */
	public String getContactWay() {
		return contactWay;
	}
	/**
	 * 设置：是否有效(0:无效，1:有效)
	 */
	public void setEffective(Integer effective) {
		this.effective = effective;
	}
	/**
	 * 获取：是否有效(0:无效，1:有效)
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
}
