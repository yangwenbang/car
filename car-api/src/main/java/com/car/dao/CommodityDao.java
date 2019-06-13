package com.car.dao;

import java.util.List;

import com.car.form.UpdateOldCommodityForm;
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

    List<CommodityVO> queryCommoditysByCategoryId(@Param("commodityCategoryId") long commodityCategoryId,
			@Param("pageId") int pageId,
			@Param("pageSize") int pageSize) throws DAOException;

    void deleteCommodityById(Long commodityById) throws DAOException;

    void updateCommodityById(UpdateOldCommodityForm commodityForm) throws DAOException;

    List<CommodityVO> queryUserOldCommoditysByUserId(Long userId) throws DAOException;

}
