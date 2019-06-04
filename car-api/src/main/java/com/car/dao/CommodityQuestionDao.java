package com.car.dao;

import com.car.dto.CommodityQuestionChildDTO;
import com.car.dto.MainPageInfoDTO;
import com.car.entity.CommodityQuestion;
import com.car.exception.DAOException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityQuestionDao {
    void insertCommodityQuestion(CommodityQuestion commodityQuestionEntity) throws DAOException;

    List<CommodityQuestionChildDTO> queryCommodityQuestionsByTypeId(@Param("questionTypeId") long questionTypeId,
        @Param("questionType") Integer questionType) throws DAOException;

    Long getUserIdByCommodityId(Long questionTypeId);

    Long getUserIdByPublishPostId(Long questionTypeId);

    List<MainPageInfoDTO> queryPageInfoCommodityQuestions(@Param("pageId") int pageId,
        @Param("pageSize") int pageSize) throws DAOException;
}
