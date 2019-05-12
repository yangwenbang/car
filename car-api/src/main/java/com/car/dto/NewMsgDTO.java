package com.car.dto;

import java.io.Serializable;
import java.util.List;

import com.car.vo.NewMsgVO;

public class NewMsgDTO implements Serializable {

	private static final long serialVersionUID = 8995356153243069358L;

	private long msgTypeId;
	private String msgTypeName;
	private List<NewMsgVO> newMsgs;
	
	public NewMsgDTO() {}

	public NewMsgDTO(long msgTypeId, String msgTypeName, List<NewMsgVO> newMsgs) {
		this.msgTypeId = msgTypeId;
		this.msgTypeName = msgTypeName;
		this.newMsgs = newMsgs;
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

	public List<NewMsgVO> getNewMsgs() {
		return newMsgs;
	}

	public void setNewMsgs(List<NewMsgVO> newMsgs) {
		this.newMsgs = newMsgs;
	}

}
