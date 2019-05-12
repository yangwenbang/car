package com.car.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.ApiConstants;
import com.car.dao.CourseDao;
import com.car.exception.DAOException;
import com.car.service.CourseService;
import com.car.vo.CourseVO;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;

	@Override
	public List<CourseVO> getFamousCoursesByProjectAndCategory(long userId, 
			long projectId, 
			long categoryId, 
			int courseType,
			int limitCount) throws DAOException {
		return courseDao.getFamousCoursesByProjectAndCategory(userId, projectId, categoryId, courseType, limitCount);
	}

	@Override
	public List<CourseVO> getLastCoursesByProjectAndCategory(long userId, 
			long projectId, 
			long categoryId,
			int courseType) throws DAOException {
		return courseDao.getLastCoursesByProjectAndCategory(userId, projectId, categoryId, courseType);
	}

	@Override
	public List<CourseVO> getAllCoursesByCondition(long userId, long projectId, long categoryId, int courseType) throws DAOException {
		return courseDao.getAllCoursesByCondition(userId, projectId, categoryId, courseType);
	}

	@Override
	public List<CourseVO> getDailyExercisesByCondition(long userId, long projectId, int courseType, int pageId) throws DAOException {
		
		int pageSize = pageId * ApiConstants.PAGE_COUNT;
		
		return courseDao.getDailyExercisesByCondition(userId, projectId, courseType, pageSize, ApiConstants.PAGE_COUNT);
	}
	
}
