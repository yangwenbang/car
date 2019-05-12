package com.car.vo;

import java.io.Serializable;

public class ChapterVO implements Serializable {

	private static final long serialVersionUID = -1544783718646301159L;
	
	private long chapterId;
	private long courseId;
	private String chapterName;
	private String description;
	private String execContent;
	private String execUrl;
	private int seq;

	public long getChapterId() {
		return chapterId;
	}

	public void setChapterId(long chapterId) {
		this.chapterId = chapterId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExecContent() {
		return execContent;
	}

	public void setExecContent(String execContent) {
		this.execContent = execContent;
	}

	public String getExecUrl() {
		return execUrl;
	}

	public void setExecUrl(String execUrl) {
		this.execUrl = execUrl;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

}