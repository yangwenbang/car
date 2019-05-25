package com.car.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.car.entity.OldCommodity;
import com.car.exception.DAOException;
import com.car.vo.CommodityVO;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 21:33:04
 */
public interface CommodityDao {

    void insertCommodity(OldCommodity commodityEntity);

    List<CommodityVO> queryCommoditysByCategoryId(@Param("CommodityCategoryId") long CommodityCategoryId,
			@Param("pageId") int pageId,
			@Param("pageSize") int pageSize) throws DAOException;
}
