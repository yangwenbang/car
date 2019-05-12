package com.car.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.ExerciseTypeDao;
import com.car.service.ExerciseTypeService;

@Service("exerciseTypeService")
public class ExerciseTypeServiceImpl implements ExerciseTypeService {
	@Autowired
	private ExerciseTypeDao exerciseTypeDao;


}
