package com.car.dao;

import java.util.List;

import com.car.entity.UserProject;
import com.car.exception.DAOException;
import com.car.vo.UserCoursePlanVO;
import com.car.vo.UserProjectVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface UserCoursePlanDao {
	
	List<UserCoursePlanVO> getUserCoursePlansByCondition(long userId, long courseId) throws DAOException;
	
}
