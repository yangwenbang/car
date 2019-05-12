package com.car.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.UserCoursePlanDao;
import com.car.exception.DAOException;
import com.car.service.UserCoursePlanService;
import com.car.vo.UserCoursePlanVO;

@Service("userCoursePlanService")
public class UserCoursePlanServiceImpl implements UserCoursePlanService {
	@Autowired
	private UserCoursePlanDao userCoursePlanDao;

	@Override
	public List<UserCoursePlanVO> getUserCoursePlansByCondition(long userId, long courseId) throws DAOException {
		return userCoursePlanDao.getUserCoursePlansByCondition(userId, courseId);
	}


}
