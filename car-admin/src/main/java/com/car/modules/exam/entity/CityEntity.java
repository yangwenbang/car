package com.car.modules.car.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-25 01:44:49
 */
@TableName("city")
public class CityEntity extends Model<CityEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 城市id
	 */
	@TableId
	private Long id;
	/**
	 * 省份id
	 */
	private Long provinceId;
	/**
	 * 城市名
	 */
	private String cityName;
	/**
	 * 地址
	 */
	private String cityAddress;
	/**
	 * 电话
	 */
	private String cityTelephone;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 设置：城市id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：城市id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：省份id
	 */
	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}
	/**
	 * 获取：省份id
	 */
	public Long getProvinceId() {
		return provinceId;
	}
	/**
	 * 设置：城市名
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * 获取：城市名
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * 设置：地址
	 */
	public void setCityAddress(String cityAddress) {
		this.cityAddress = cityAddress;
	}
	/**
	 * 获取：地址
	 */
	public String getCityAddress() {
		return cityAddress;
	}
	/**
	 * 设置：电话
	 */
	public void setCityTelephone(String cityTelephone) {
		this.cityTelephone = cityTelephone;
	}
	/**
	 * 获取：电话
	 */
	public String getCityTelephone() {
		return cityTelephone;
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

	@Override
	protected Serializable pkVal() {
		return id;
	}
}
