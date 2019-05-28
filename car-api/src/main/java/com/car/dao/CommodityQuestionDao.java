package com.car.dao;

import com.car.entity.CommodityQuestion;
import com.car.exception.DAOException;

public interface CommodityQuestionDao {
    void insertCommodityQuestion(CommodityQuestion commodityQuestionEntity) throws DAOException;;
}
