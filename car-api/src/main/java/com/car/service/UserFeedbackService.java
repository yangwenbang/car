package com.car.service;




import com.car.exception.DAOException;
import com.car.form.UserFeedbackFrom;

public interface UserFeedbackService {


	void insertUserFeedback(UserFeedbackFrom userFeedbackFrom) throws DAOException;
}
