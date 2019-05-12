package com.car.dao;

import java.util.List;

import com.car.exception.DAOException;
import com.car.vo.CourseVO;

import io.lettuce.core.dynamic.annotation.Param;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface CourseDao {
	
	List<CourseVO> getFamousCoursesByProjectAndCategory(@Param("userId") long userId, 
			@Param("projectId") long projectId, 
			@Param("categoryId") long categoryId, 
			@Param("courseType") int courseType,
			@Param("limitCoint") int limitCount) throws DAOException;
	
	List<CourseVO> getLastCoursesByProjectAndCategory(@Param("userId") long userId, 
			@Param("projectId") long projectId, 
			@Param("categoryId") long categoryId, 
			@Param("courseType") int courseType) throws DAOException;
	
	List<CourseVO> getAllCoursesByCondition(@Param("userId") long userId, 
			@Param("projectId") long projectId, 
			@Param("categoryId") long categoryId,
			@Param("courseType") int courseType) throws DAOException;
			
	List<CourseVO> getDailyExercisesByCondition(@Param("userId") long userId, 
			@Param("projectId") long projectId,
			@Param("courseType") int courseType,
			@Param("pageId") int pageId,
			@Param("pageSize") int pageSize) throws DAOException;
	
}
