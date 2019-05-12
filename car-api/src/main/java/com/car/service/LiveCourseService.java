package com.car.service;

import java.util.List;

import com.car.exception.DAOException;
import com.car.vo.LiveCourseVO;

/**
 * @author wind
 */
public interface LiveCourseService {
	
	List<LiveCourseVO> getLiveCoursesByUser(long userId) throws DAOException;

}

