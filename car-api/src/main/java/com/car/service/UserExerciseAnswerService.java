package com.car.service;

import com.car.exception.DAOException;
import com.car.form.UserExerciseAnswerForm;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface UserExerciseAnswerService {
	
	void saveUserExerciseAnswer(UserExerciseAnswerForm userExerciseAnswerForm) throws DAOException;

}
