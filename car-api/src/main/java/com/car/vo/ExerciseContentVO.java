package com.car.vo;

import java.io.Serializable;

public class ExerciseContentVO implements Serializable {

	private static final long serialVersionUID = 3116660179814412959L;
	
	private Long exerciseTypeId;
	private Long exerciseContentId;
	private String exerciseName;
	private String exerciseContent;
	private String optionss;
	private String rightAnswer;
	private String answerAnalysis;
	private Integer score;
	private String exerciseContentPicture;
	private String exerciseAnswerPicture;
	private String exerciseOptionPicture;
	private Integer exerciseType;
	private String description;

	public Long getExerciseTypeId() {
		return exerciseTypeId;
	}

	public void setExerciseTypeId(Long exerciseTypeId) {
		this.exerciseTypeId = exerciseTypeId;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getExerciseContent() {
		return this.exerciseContent;
	}

	public void setExerciseContent(String exerciseContent) {
		this.exerciseContent = exerciseContent;
	}

	public String getRightAnswer() {
		return this.rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public String getAnswerAnalysis() {
		return this.answerAnalysis;
	}

	public void setAnswerAnalysis(String answerAnalysis) {
		this.answerAnalysis = answerAnalysis;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getExerciseContentPicture() {
		return this.exerciseContentPicture;
	}

	public void setExerciseContentPicture(String exerciseContentPicture) {
		this.exerciseContentPicture = exerciseContentPicture;
	}

	public Long getExerciseContentId() {
		return exerciseContentId;
	}

	public void setExerciseContentId(Long exerciseContentId) {
		this.exerciseContentId = exerciseContentId;
	}

	public String getOptionss() {
		return optionss;
	}

	public void setOptionss(String optionss) {
		this.optionss = optionss;
	}

	public String getExerciseAnswerPicture() {
		return exerciseAnswerPicture;
	}

	public void setExerciseAnswerPicture(String exerciseAnswerPicture) {
		this.exerciseAnswerPicture = exerciseAnswerPicture;
	}

	public Integer getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(Integer exerciseType) {
		this.exerciseType = exerciseType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExerciseOptionPicture() {
		return exerciseOptionPicture;
	}

	public void setExerciseOptionPicture(String exerciseOptionPicture) {
		this.exerciseOptionPicture = exerciseOptionPicture;
	}

}