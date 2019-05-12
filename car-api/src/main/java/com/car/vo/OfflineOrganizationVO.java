package com.car.vo;

import java.io.Serializable;

public class OfflineOrganizationVO implements Serializable {

	private static final long serialVersionUID = -5699583674001396079L;

	private Long offlineOrganizationId;
	private String organizationName;
	private String organizationAddress;
	private String contact;
	private String phone;
	private String organizationDesc;
	private String organizationPicture;
	private String askUrl;

	public Long getOfflineOrganizationId() {
		return offlineOrganizationId;
	}

	public void setOfflineOrganizationId(Long offlineOrganizationId) {
		this.offlineOrganizationId = offlineOrganizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationAddress() {
		return organizationAddress;
	}

	public void setOrganizationAddress(String organizationAddress) {
		this.organizationAddress = organizationAddress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrganizationDesc() {
		return organizationDesc;
	}

	public void setOrganizationDesc(String organizationDesc) {
		this.organizationDesc = organizationDesc;
	}

	public String getOrganizationPicture() {
		return organizationPicture;
	}

	public void setOrganizationPicture(String organizationPicture) {
		this.organizationPicture = organizationPicture;
	}

	public String getAskUrl() {
		return askUrl;
	}

	public void setAskUrl(String askUrl) {
		this.askUrl = askUrl;
	}

}