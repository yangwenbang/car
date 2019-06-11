package com.car.dao;

import com.car.dto.CommodityQuestionChildDTO;
import com.car.dto.CommodityQuestionDTO;
import com.car.dto.MainPageInfoDTO;
import com.car.entity.CommodityQuestion;
import com.car.exception.DAOException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityQuestionDao {
    void insertCommodityQuestion(CommodityQuestion commodityQuestionEntity) throws DAOException;

    Long getUserIdByCommodityId(Long questionTypeId);

    Long getUserIdByPublishPostId(Long questionTypeId);

    List<MainPageInfoDTO> queryPageInfoCommodityQuestions(@Param("pageId") int pageId,
        @Param("pageSize") int pageSize) throws DAOException;

    List<CommodityQuestionDTO> queryParentCommodityQuestionsByTypeId(@Param("questionTypeId") Long questionTypeId,
    @Param("questionType") Integer questionType);

    List<CommodityQuestionChildDTO> queryCommodityQuestionsByParentIds(@Param("parentIdLsit") List<Long> parentIdLsit,
    @Param("questionTypeId") long questionTypeId,@Param("questionType") Integer questionType);
}
