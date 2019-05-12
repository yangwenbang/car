package com.car.dao;

import java.util.List;

import com.car.exception.DAOException;
import com.car.vo.LiveCourseVO;

/**
 * @author wind
 */
public interface LiveCourseDao {
	
	List<LiveCourseVO> getLiveCoursesByUser(long userId) throws DAOException;
	
}
