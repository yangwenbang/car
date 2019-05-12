package com.car.vo;

import java.io.Serializable;
import java.util.List;

public class ProvinceAndCityVO implements Serializable {

	private static final long serialVersionUID = -4293133897193014114L;
	
	private ProvinceVO province;
	private List<CityVO> citys;
	
	public ProvinceAndCityVO() {
	}

	public ProvinceAndCityVO(ProvinceVO province, List<CityVO> citys) {
		this.province = province;
		this.citys = citys;
	}

	public ProvinceVO getProvince() {
		return province;
	}

	public void setProvince(ProvinceVO province) {
		this.province = province;
	}

	public List<CityVO> getCitys() {
		return citys;
	}

	public void setCitys(List<CityVO> citys) {
		this.citys = citys;
	}

}
