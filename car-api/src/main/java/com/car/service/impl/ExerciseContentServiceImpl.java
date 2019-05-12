package com.car.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.ExerciseContentDao;
import com.car.exception.DAOException;
import com.car.service.ExerciseContentService;
import com.car.vo.ExerciseContentVO;

@Service("exerciseContentService")
public class ExerciseContentServiceImpl implements ExerciseContentService {
	@Autowired
	private ExerciseContentDao exerciseContentDao;

	@Override
	public List<ExerciseContentVO> getExerciseContentsBySection(long sectionId) throws DAOException {
		return exerciseContentDao.getExerciseContentsBySection(sectionId);
	}


}
