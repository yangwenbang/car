package com.car.vo;

import java.io.Serializable;

public class NewMsgVO implements Serializable {

	private static final long serialVersionUID = 5486487334094661358L;

	private long newMsgId;
	private long msgTypeId;
	private String oneWord;
	private String msgName;
	private String msgTypeName;
	private String msgContentUrl;
	private String publishDate;

	public long getNewMsgId() {
		return newMsgId;
	}

	public void setNewMsgId(long newMsgId) {
		this.newMsgId = newMsgId;
	}

	public String getOneWord() {
		return oneWord;
	}

	public void setOneWord(String oneWord) {
		this.oneWord = oneWord;
	}

	public String getMsgContentUrl() {
		return msgContentUrl;
	}

	public void setMsgContentUrl(String msgContentUrl) {
		this.msgContentUrl = msgContentUrl;
	}

	public long getMsgTypeId() {
		return msgTypeId;
	}

	public void setMsgTypeId(long msgTypeId) {
		this.msgTypeId = msgTypeId;
	}

	public String getMsgTypeName() {
		return msgTypeName;
	}

	public void setMsgTypeName(String msgTypeName) {
		this.msgTypeName = msgTypeName;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getMsgName() {
		return msgName;
	}

	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}

}