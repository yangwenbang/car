package com.car.service;


import com.car.exception.DAOException;
import com.car.form.CommodityQuestionFrom; /**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-27 01:05:41
 */
public interface CommodityQuestionService {

    void insertCommodityQuestion(CommodityQuestionFrom commodityQuestionFrom) throws DAOException;
}

