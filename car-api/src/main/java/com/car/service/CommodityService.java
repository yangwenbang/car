package com.car.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.car.entity.OldCommodity;
import com.car.form.OldCommodityForm;
import com.car.vo.CommodityCategoryVO;
import com.car.vo.CommodityVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 21:33:04
 */
public interface CommodityService {

    OldCommodity insertCommodity(OldCommodityForm commodity);

    List<CommodityCategoryVO> queryCommodityCategorys();

    Page<CommodityVO> queryCommoditysByCategoryId(Page<CommodityVO> page,@Param("commodityCategoryId") String commodityCategoryId);
}

