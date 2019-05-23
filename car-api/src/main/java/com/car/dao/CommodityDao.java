package com.car.dao;

import com.car.entity.OldCommodity;
import com.car.vo.CommodityCategoryVo;
import com.car.vo.CommodityVO;

import java.util.List;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 21:33:04
 */
public interface CommodityDao {

    void insertCommodity(OldCommodity commodityEntity);

    List<CommodityCategoryVo> listCommodityCategory();

    List<CommodityVO> listCommodityByCategoryId(String commodityCategoryId);
}
