package com.car.vo;

import java.io.Serializable;

public class CategoryVO implements Serializable {

	private static final long serialVersionUID = -5246891791064752353L;

	private Long categoryId;
	private String categoryName;
	
	public CategoryVO() {
	}

	public CategoryVO(Long categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
