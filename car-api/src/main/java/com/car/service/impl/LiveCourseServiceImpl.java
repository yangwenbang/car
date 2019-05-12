package com.car.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.LiveCourseDao;
import com.car.exception.DAOException;
import com.car.service.LiveCourseService;
import com.car.vo.LiveCourseVO;

@Service("liveCourseService")
public class LiveCourseServiceImpl implements LiveCourseService {

	@Autowired
	private LiveCourseDao liveCourseDao;

	@Override
	public List<LiveCourseVO> getLiveCoursesByUser(long userId) throws DAOException {
		return liveCourseDao.getLiveCoursesByUser(userId);
	}

}
