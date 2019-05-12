package com.car.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.UserExerciseAnswerDao;
import com.car.exception.DAOException;
import com.car.form.UserExerciseAnswerForm;
import com.car.service.UserExerciseAnswerService;

@Service("userExerciseAnswerService")
public class UserExerciseAnswerServiceImpl implements UserExerciseAnswerService {
	
	private static final Logger log = LoggerFactory.getLogger(UserExerciseAnswerServiceImpl.class);

	@Autowired
	private UserExerciseAnswerDao userExerciseAnswerDao;

	@Override
	public void saveUserExerciseAnswer(UserExerciseAnswerForm userExerciseAnswerForm) throws DAOException {
		
		log.info("userId:{},score:{},spendTime:{}",userExerciseAnswerForm.getUserId(),userExerciseAnswerForm.getScore(),userExerciseAnswerForm.getSpendTime());
		
		log.info("ExerciseAnswer:{}", userExerciseAnswerForm.getExerciseAnswers());
		
	}



}
