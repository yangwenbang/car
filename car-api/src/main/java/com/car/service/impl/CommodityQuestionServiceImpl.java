package com.car.service.impl;

import com.car.dao.CommodityQuestionDao;
import com.car.entity.CommodityQuestion;
import com.car.exception.DAOException;
import com.car.form.CommodityQuestionFrom;
import com.car.service.CommodityQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service("commodityQuestionService")
public class CommodityQuestionServiceImpl implements CommodityQuestionService {

    @Autowired
    private CommodityQuestionDao commodityQuestionDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertCommodityQuestion(CommodityQuestionFrom commodityQuestionFrom) throws DAOException {
        CommodityQuestion commodityQuestionEntity = new CommodityQuestion();
        commodityQuestionEntity.setParentId(commodityQuestionFrom.getCommodityQuestionParentId());
        commodityQuestionEntity.setQuestionTypeId(commodityQuestionFrom.getQuestionTypeId());
        commodityQuestionEntity.setQuestionType(commodityQuestionFrom.getQuestionType());
        commodityQuestionEntity.setUserId(commodityQuestionFrom.getUserId());
        commodityQuestionEntity.setUserName(commodityQuestionFrom.getUserName());
        commodityQuestionEntity.setReplayContent(commodityQuestionFrom.getReplayContent());
        commodityQuestionEntity.setReplayDate(new Date());
        commodityQuestionEntity.setReplayStatus(commodityQuestionFrom.getReplayStatus());
        commodityQuestionEntity.setCreateTime(new Date());
        commodityQuestionEntity.setUpdateTime(new Date());
        commodityQuestionDao.insertCommodityQuestion(commodityQuestionEntity);
    }
}
