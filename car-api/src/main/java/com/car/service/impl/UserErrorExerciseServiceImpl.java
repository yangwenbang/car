package com.car.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.UserErrorExerciseDao;
import com.car.service.UserErrorExerciseService;


@Service("userErrorExerciseService")
public class UserErrorExerciseServiceImpl implements UserErrorExerciseService {

	@Autowired
	private UserErrorExerciseDao UserErrorExerciseDao;
    
}
