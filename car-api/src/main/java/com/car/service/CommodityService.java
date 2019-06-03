package com.car.service;

import java.util.List;

import com.car.exception.DAOException;
import com.car.form.OldCommodityForm;
import com.car.vo.CommodityVO;


/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 21:33:04
 */
public interface CommodityService {

    void insertCommodity(OldCommodityForm commodity) throws DAOException;

    List<CommodityVO> queryCommoditysByCategoryId(long commodityCategoryId, int pageId) throws DAOException;
}

