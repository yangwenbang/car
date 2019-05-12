package com.car.vo;

import java.io.Serializable;

public class AboutCompanyVO implements Serializable {

	private static final long serialVersionUID = -5699583674001396079L;

	private String companyName;
	private String companyAddress;
	private String companyContact;
	private String companyPhone;
	private String companyDesc;
	private String companyPicture;

	public String getCompanyName() {
		return companyName == null ? "" : companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress == null ? "" : companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyContact() {
		return companyContact == null ? "" : companyContact;
	}

	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}

	public String getCompanyPhone() {
		return companyPhone == null ? "" : companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getCompanyDesc() {
		return companyDesc == null ? "" : companyDesc;
	}

	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}

	public String getCompanyPicture() {
		return companyPicture == null ? "" : companyPicture;
	}

	public void setCompanyPicture(String companyPicture) {
		this.companyPicture = companyPicture;
	}

}