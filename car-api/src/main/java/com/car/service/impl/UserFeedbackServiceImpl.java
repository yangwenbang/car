package com.car.service.impl;


import com.car.dao.UserFeedbackDao;
import com.car.entity.UserFeedback;
import com.car.exception.DAOException;
import com.car.form.UserFeedbackFrom;
import com.car.service.UserFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("userFeedbackService")
public class UserFeedbackServiceImpl implements UserFeedbackService {

	@Autowired
	private UserFeedbackDao userFeedbackDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertUserFeedback(UserFeedbackFrom userFeedbackFrom) throws DAOException {
		UserFeedback userFeedback = new UserFeedback();
		userFeedback.setContent(userFeedbackFrom.getContent());
		userFeedback.setUserId(userFeedbackFrom.getUserId());
		userFeedback.setCreateTime(new Date());
		userFeedbackDao.insertUserFeedback(userFeedback);
	}
}
