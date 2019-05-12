package com.car.service;

import java.util.List;

import com.car.exception.DAOException;
import com.car.form.UserProjectForm;
import com.car.vo.UserCoursePlanVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface UserCoursePlanService {

	List<UserCoursePlanVO> getUserCoursePlansByCondition(long userId, long courseId) throws DAOException;
	
}
