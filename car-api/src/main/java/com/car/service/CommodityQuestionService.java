package com.car.service;


import com.car.dto.MainPageInfoDTO;
import com.car.exception.DAOException;
import com.car.form.CommodityQuestionFrom;
import com.car.dto.CommodityQuestionDTO;

import java.util.List;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-27 01:05:41
 */
public interface CommodityQuestionService {

    void insertCommodityQuestion(CommodityQuestionFrom commodityQuestionFrom) throws DAOException;

    List<CommodityQuestionDTO> queryCommodityQuestionsByTypeId(long questionTypeId, Integer questionType) throws DAOException;

    List<MainPageInfoDTO> queryPageInfoCommodityQuestions(int pageId) throws DAOException;
}

