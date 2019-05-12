package com.car.vo;

import java.io.Serializable;

public class ExerContentVO implements Serializable {

	private static final long serialVersionUID = 3116660179814412959L;

	private Long exerciseContentId;
	private String exerciseContent;
	private String optionss;
	private String rightAnswer;
	private String answerAnalysis;
	private Integer score;
	private String exerciseContentPicture;
	private String exerciseAnswerPicture;

	public Long getExerciseContentId() {
		return exerciseContentId;
	}

	public void setExerciseContentId(Long exerciseContentId) {
		this.exerciseContentId = exerciseContentId;
	}

	public String getExerciseContent() {
		return exerciseContent;
	}

	public void setExerciseContent(String exerciseContent) {
		this.exerciseContent = exerciseContent;
	}

	public String getOptionss() {
		return optionss;
	}

	public void setOptionss(String optionss) {
		this.optionss = optionss;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public String getAnswerAnalysis() {
		return answerAnalysis;
	}

	public void setAnswerAnalysis(String answerAnalysis) {
		this.answerAnalysis = answerAnalysis;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getExerciseContentPicture() {
		return exerciseContentPicture;
	}

	public void setExerciseContentPicture(String exerciseContentPicture) {
		this.exerciseContentPicture = exerciseContentPicture;
	}

	public String getExerciseAnswerPicture() {
		return exerciseAnswerPicture;
	}

	public void setExerciseAnswerPicture(String exerciseAnswerPicture) {
		this.exerciseAnswerPicture = exerciseAnswerPicture;
	}

}