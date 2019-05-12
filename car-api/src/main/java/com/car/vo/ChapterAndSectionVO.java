package com.car.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChapterAndSectionVO implements Serializable {

	private static final long serialVersionUID = -2636829023350916977L;
	
	private String chapter;
	private List<SectionVO> sections;
	
	public ChapterAndSectionVO() {
	}

	public ChapterAndSectionVO(String chapter, List<SectionVO> sections) {
		this.chapter = chapter;
		this.sections = sections;
	}

	public String getChapter() {
		return chapter == null ? "" : chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public List<SectionVO> getSections() {
		return sections == null ? new ArrayList<SectionVO>() : sections;
	}

	public void setSections(List<SectionVO> sections) {
		this.sections = sections;
	}

}