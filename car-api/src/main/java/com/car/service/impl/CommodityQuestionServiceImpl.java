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

import java.util.ArrayList;
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
        Long userId;
        if (commodityQuestionFrom.getReplayStatus().equals(1)){
            if (commodityQuestionFrom.getQuestionType() == 0) {
                userId = commodityQuestionDao.getUserIdByCommodityId(commodityQuestionFrom.getQuestionTypeId());
            } else if (commodityQuestionFrom.getQuestionType() == 1) {
                userId = commodityQuestionDao.getUserIdByPublishPostId(commodityQuestionFrom.getQuestionTypeId());
            } else {
                throw new DAOException("提问类型不符合规范");
            }
            if (userId == null || !userId.equals(commodityQuestionFrom.getUserId())) {
                throw new DAOException("你没有回复的权限");
            }
        }
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
    public List<CommodityQuestionDTO> queryCommodityQuestionsByTypeId(long questionTypeId, Integer questionType) throws DAOException {
        List<CommodityQuestionDTO> commodityQuestionList = commodityQuestionDao.queryCommodityQuestionsByTypeId(questionTypeId, questionType);
        if (commodityQuestionList == null || commodityQuestionList.isEmpty()){
            return commodityQuestionList;
        }
        List<CommodityQuestionDTO> list = new ArrayList<>();
        for (CommodityQuestionDTO commodityQuestion : commodityQuestionList) {
            if (commodityQuestion.getParentId() == -1) {
                commodityQuestion.setCommodityQuestionList(getChildrenNode(commodityQuestion.getCommodityQuestionId(), commodityQuestionList));
                list.add(commodityQuestion);
            }
        }
        return list;
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

    // 获取子问答的递归方法
    public List<CommodityQuestionDTO> getChildrenNode(Long id, List<CommodityQuestionDTO> commodityQuestionList) {
        List<CommodityQuestionDTO> newCommodityQuestionList = new ArrayList<>();
        for (CommodityQuestionDTO commodityQuestion : commodityQuestionList) {
            if (commodityQuestion.getParentId().equals(id)) {
                commodityQuestion.setCommodityQuestionList(getChildrenNode(commodityQuestion.getCommodityQuestionId(), commodityQuestionList));
                newCommodityQuestionList.add(commodityQuestion);
            }
        }
        return newCommodityQuestionList;
    }

}
