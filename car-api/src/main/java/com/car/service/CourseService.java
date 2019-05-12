package com.car.service;

import java.util.List;

import com.car.exception.DAOException;
import com.car.vo.CourseVO;

import io.lettuce.core.dynamic.annotation.Param;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface CourseService {

	List<CourseVO> getFamousCoursesByProjectAndCategory(long userId, 
			long projectId, 
			long categoryId, 
			int courseType,
			int limitCount) throws DAOException;
	
	List<CourseVO> getLastCoursesByProjectAndCategory(long userId, 
			long projectId, 
			long categoryId, 
			int courseType) throws DAOException;
	
	List<CourseVO> getAllCoursesByCondition(long userId, 
			long projectId, 
			long categoryId,
			int courseType) throws DAOException;
	
	List<CourseVO> getDailyExercisesByCondition(long userId, 
			long projectId,
			int courseType,
			int pageId) throws DAOException;
}
