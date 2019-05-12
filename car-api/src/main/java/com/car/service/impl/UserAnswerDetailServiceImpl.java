package com.car.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.UserAnswerDetailDao;
import com.car.service.UserAnswerDetailService;


@Service("userAnswerDetailService")
public class UserAnswerDetailServiceImpl implements UserAnswerDetailService {

	@Autowired
	private UserAnswerDetailDao userAnswerDetailDao;

}
