package com.car.service.impl;

import com.car.ApiConstants;
import com.car.dao.CommodityQuestionDao;
import com.car.dto.MainPageInfoDTO;
import com.car.entity.CommodityQuestion;
import com.car.exception.DAOException;
import com.car.form.CommodityQuestionFrom;
import com.car.service.CommodityQuestionService;
import com.car.dto.CommodityQuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service("commodityQuestionService")
public class CommodityQuestionServiceImpl implements CommodityQuestionService {

    @Autowired
    private CommodityQuestionDao commodityQuestionDao;

    private static final Integer PUBLISHPOST_TYPE = 1;

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

    @Override
    public List<CommodityQuestionDTO> queryCommodityQuestionsByTypeId(long questionTypeId,Integer questionType) throws DAOException {
        return commodityQuestionDao.queryCommodityQuestionsByTypeId(questionTypeId,questionType);
    }

    @Override
    public List<MainPageInfoDTO> queryPageInfoCommodityQuestions(int pageId) throws DAOException {
        int pageSize = pageId * ApiConstants.PAGE_COUNT;
        List<MainPageInfoDTO> mainPageInfoList = commodityQuestionDao.queryPageInfoCommodityQuestions(pageSize, ApiConstants.PAGE_COUNT);
        for (MainPageInfoDTO MainPageInfo : mainPageInfoList) {
            MainPageInfo.setCommodityQuestionList(queryCommodityQuestionsByTypeId(MainPageInfo.getPublishPostId(),PUBLISHPOST_TYPE));
        }
        return mainPageInfoList;
    }

    @Override
    public Long getUserIdByCommodityId(Long questionTypeId) {
        return commodityQuestionDao.getUserIdByCommodityId(questionTypeId);
    }

    @Override
    public Long getUserIdByPublishPostId(Long questionTypeId) throws DAOException {
        return commodityQuestionDao.getUserIdByPublishPostId(questionTypeId);
    }

}
