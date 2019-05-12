package com.car.dto;

import java.io.Serializable;
import java.util.List;

public class ProvinceAndCityNameDTO implements Serializable {

	private static final long serialVersionUID = 1162075001376124996L;
	private String province;
	private List<String> cities;
	
	public ProvinceAndCityNameDTO() {
	}
	
	public ProvinceAndCityNameDTO(String province, List<String> cities) {
		super();
		this.province = province;
		this.cities = cities;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	

}
