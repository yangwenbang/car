package com.car.vo;

import java.io.Serializable;

public class ParamSetVO implements Serializable {

	private Long paramSetId;
	private Integer isLoginShow;
	private String exerciseShareContext;
	private String dailyShareContext;
	private String equipmentVersion;
	private Integer isMobileShow;

	public Long getParamSetId() {
		return paramSetId;
	}

	public void setParamSetId(Long paramSetId) {
		this.paramSetId = paramSetId;
	}

	public Integer getIsLoginShow() {
		return isLoginShow;
	}

	public void setIsLoginShow(Integer isLoginShow) {
		this.isLoginShow = isLoginShow;
	}

	public String getExerciseShareContext() {
		return exerciseShareContext;
	}

	public void setExerciseShareContext(String exerciseShareContext) {
		this.exerciseShareContext = exerciseShareContext;
	}

	public String getDailyShareContext() {
		return dailyShareContext;
	}

	public void setDailyShareContext(String dailyShareContext) {
		this.dailyShareContext = dailyShareContext;
	}

	public String getEquipmentVersion() {
		return equipmentVersion;
	}

	public void setEquipmentVersion(String equipmentVersion) {
		this.equipmentVersion = equipmentVersion;
	}

	public Integer getIsMobileShow() {
		return isMobileShow;
	}

	public void setIsMobileShow(Integer isMobileShow) {
		this.isMobileShow = isMobileShow;
	}

}