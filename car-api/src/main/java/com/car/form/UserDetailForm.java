package com.car.form;

/**
 * @author wind
 */
public class UserDetailForm {

	private Long userId;
	private String columnNames;
	private String columnValues;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String columnNames) {
		this.columnNames = columnNames;
	}

	public String getColumnValues() {
		return columnValues;
	}

	public void setColumnValues(String columnValues) {
		this.columnValues = columnValues;
	}

}
