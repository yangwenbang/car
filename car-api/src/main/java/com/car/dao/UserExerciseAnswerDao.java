package com.car.dao;

import com.car.entity.UserExerciseAnswer;
import com.car.exception.DAOException;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface UserExerciseAnswerDao {
	
	void saveUserExerciseAnswer(UserExerciseAnswer userExerciseAnswer) throws DAOException;
	
}
