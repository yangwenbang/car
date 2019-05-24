package com.car.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.car.entity.OldCommodity;
import com.car.vo.CommodityCategoryVO;
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

    List<CommodityCategoryVO> queryCommodityCategorys();

    Page<CommodityVO> queryCommoditysByCategoryId(Page<CommodityVO> page, String commodityCategoryId);
}
