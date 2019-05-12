package com.car.form;

/**
 * @author wind
 */
public class ExerciseAnswerForm {

	private Long exerciseContentId;
	private String exerciseAnswer;
	

	public ExerciseAnswerForm() {
	}

	public ExerciseAnswerForm(Long exerciseContentId, String exerciseAnswer) {
		this.exerciseContentId = exerciseContentId;
		this.exerciseAnswer = exerciseAnswer;
	}

	public Long getExerciseContentId() {
		return exerciseContentId;
	}

	public void setExerciseContentId(Long exerciseContentId) {
		this.exerciseContentId = exerciseContentId;
	}

	public String getExerciseAnswer() {
		return exerciseAnswer;
	}

	public void setExerciseAnswer(String exerciseAnswer) {
		this.exerciseAnswer = exerciseAnswer;
	}

}
