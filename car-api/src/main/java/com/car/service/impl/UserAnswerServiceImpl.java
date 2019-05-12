package com.car.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.UserAnswerDao;
import com.car.service.UserAnswerService;


@Service("userAnswerService")
public class UserAnswerServiceImpl implements UserAnswerService {

    @Autowired
    private UserAnswerDao UserAnswerDao;

}
