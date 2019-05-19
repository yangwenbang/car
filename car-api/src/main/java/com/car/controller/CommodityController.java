package com.car.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.car.common.validator.ValidatorUtils;
import com.car.entity.CommodityEntity;
import com.car.exception.DAOException;
import com.car.form.CommodityForm;
import com.car.service.CommodityService;
import com.car.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.car.common.utils.PageUtils;
import com.car.common.utils.R;



/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 21:33:04
 */
@RestController
@RequestMapping("/car/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@ModelAttribute CommodityForm commodity) throws DAOException {
        if(commodity.getCommodityName() == null || commodity.getCommodityName().isEmpty()){
            throw new DAOException("商品名称为空");
        }
        if(commodity.getCommodityCategoryId() == null){
            throw new DAOException("商品分类不能为空");
        }
        CommodityEntity commodityEntity = new CommodityEntity();
        commodityEntity.setCommodityName(commodity.getCommodityName());
        commodityEntity.setCommodityCategoryId(commodity.getCommodityCategoryId());
        commodityEntity.setDescription(commodity.getDescription());
        commodityEntity.setUseStartTime(commodity.getUseStartTime());
        commodityEntity.setUseEndTime(commodity.getUseEndTime());
        commodityEntity.setCommodityType(1);
        commodityEntity.setTradeMode(commodity.getTradeMode());
        commodityEntity.setPublishUserId(commodity.getPublishUserId());
        commodityEntity.setCommodityPicture(commodity.getCommodityPicture());
        commodityEntity.setUseState(commodity.getUseState());
        commodityEntity.setCreateTime(new Date());
        commodityEntity.setUpdateTime(new Date());
        commodityService.insert(commodityEntity);
        return new Result(commodityEntity);
    }
}
