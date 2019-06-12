package com.car.dao;


import com.car.entity.UserFeedback;
import com.car.exception.DAOException;

public interface UserFeedbackDao {

	void insertUserFeedback(UserFeedback userFeedback) throws DAOException;
}
