package com.car.service;

import java.util.List;

import com.car.exception.DAOException;
import com.car.vo.ExerciseContentVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface ExerciseContentService {

	List<ExerciseContentVO> getExerciseContentsBySection(long sectionId) throws DAOException;

	
}
