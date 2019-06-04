package com.car.service.impl;

import com.car.ApiConstants;
import com.car.dao.CommodityQuestionDao;
import com.car.dto.CommodityQuestionChildDTO;
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

    //查出对应商品下面所有的问答封装
    @Override
    public List<CommodityQuestionDTO> queryCommodityQuestionsByTypeId(long questionTypeId, Integer questionType) throws DAOException {
        List<CommodityQuestionDTO> list = new ArrayList<>();
        List<CommodityQuestionChildDTO> commodityQuestionList = commodityQuestionDao.queryCommodityQuestionsByTypeId(questionTypeId, questionType);
        if (commodityQuestionList == null || commodityQuestionList.isEmpty()){
            return list;
        }
        CommodityQuestionDTO commodityQuestion = new CommodityQuestionDTO();
        for (CommodityQuestionChildDTO  commodityQuestionChild : commodityQuestionList) {
            if (commodityQuestionChild.getParentId() == -1) {
                List<CommodityQuestionChildDTO> newCommodityQuestionList = new ArrayList<>();
                commodityQuestion.setCommodityQuestionId(commodityQuestionChild.getCommodityQuestionId());
                commodityQuestion.setParentId(commodityQuestionChild.getParentId());
                commodityQuestion.setUserName(commodityQuestionChild.getUserName());
                commodityQuestion.setReplayContent(commodityQuestionChild.getReplayContent());
                commodityQuestion.setReplayDate(commodityQuestionChild.getReplayDate());
                commodityQuestion.setQuestionType(commodityQuestionChild.getQuestionType());
                commodityQuestion.setReplayStatus(commodityQuestionChild.getReplayStatus());
                commodityQuestion.setCommodityQuestionChilds(getChildrenNode(commodityQuestion.getCommodityQuestionId(), commodityQuestionList, newCommodityQuestionList));
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
            MainPageInfo.setCommodityQuestions(queryCommodityQuestionsByTypeId(MainPageInfo.getPublishPostId(),PUBLISHPOST_TYPE));
        }
        return mainPageInfoList;
    }

    @Override
    public Long getUserIdByCommodityId(Long questionTypeId) throws DAOException {
        return commodityQuestionDao.getUserIdByCommodityId(questionTypeId);
    }

    @Override
    public Long getUserIdByPublishPostId(Long questionTypeId) throws DAOException {
        return commodityQuestionDao.getUserIdByPublishPostId(questionTypeId);
    }

    // 取出所有的一级以下的问答加入到对应一级问答下面的集合里面
    public List<CommodityQuestionChildDTO> getChildrenNode(Long id, List<CommodityQuestionChildDTO> commodityQuestionList,List<CommodityQuestionChildDTO> newCommodityQuestionList) {
        for (CommodityQuestionChildDTO commodityQuestion : commodityQuestionList) {
            if (commodityQuestion.getParentId().equals(id)) {
                getChildrenNode(commodityQuestion.getCommodityQuestionId(), commodityQuestionList,newCommodityQuestionList);
                newCommodityQuestionList.add(commodityQuestion);
            }
        }
        return newCommodityQuestionList;
    }

}
