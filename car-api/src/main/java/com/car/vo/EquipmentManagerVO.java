package com.car.vo;

import java.io.Serializable;

public class EquipmentManagerVO implements Serializable {

	private static final long serialVersionUID = 7591942434627728389L;
	
	private Long equipmentManagerId;
	private String equipmentVersion;
	private String equipmentPath;
	private String updateContent;
	private Integer isForceUpdate;
	
	public Long getEquipmentManagerId() {
		return equipmentManagerId;
	}

	public void setEquipmentManagerId(Long equipmentManagerId) {
		this.equipmentManagerId = equipmentManagerId;
	}

	public String getEquipmentVersion() {
		return equipmentVersion;
	}

	public void setEquipmentVersion(String equipmentVersion) {
		this.equipmentVersion = equipmentVersion;
	}

	public String getEquipmentPath() {
		return equipmentPath == null ? "" : equipmentPath;
	}

	public void setEquipmentPath(String equipmentPath) {
		this.equipmentPath = equipmentPath;
	}

	public String getUpdateContent() {
		return updateContent == null ? "" : updateContent;
	}

	public void setUpdateContent(String updateContent) {
		this.updateContent = updateContent;
	}

	public Integer getIsForceUpdate() {
		return isForceUpdate;
	}

	public void setIsForceUpdate(Integer isForceUpdate) {
		this.isForceUpdate = isForceUpdate;
	}

}
