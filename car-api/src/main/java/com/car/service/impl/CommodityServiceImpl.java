package com.car.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.car.dao.CommodityDao;
import com.car.entity.OldCommodity;
import com.car.form.OldCommodityForm;
import com.car.service.CommodityService;
import com.car.vo.CommodityCategoryVO;
import com.car.vo.CommodityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;

    @Transactional(rollbackFor = Exception.class)
    public OldCommodity insertCommodity(OldCommodityForm commodity) {
        OldCommodity commodityEntity = new OldCommodity();
        commodityEntity.setCommodityName(commodity.getCommodityName());
        commodityEntity.setCommodityCategoryId(commodity.getCommodityCategoryId());
        commodityEntity.setDescription(commodity.getDescription());
        commodityEntity.setUseStartTime(commodity.getUseStartTime());
        commodityEntity.setUseEndTime(commodity.getUseEndTime());
        commodityEntity.setTradeMode(commodity.getTradeMode());
        commodityEntity.setPublishUserId(commodity.getPublishUserId());
        commodityEntity.setCommodityPicture(commodity.getCommodityPicture());
        commodityEntity.setUseState(commodity.getUseState());
        commodityEntity.setBrand(commodity.getBrand());
        commodityEntity.setModel(commodity.getModel());
        commodityEntity.setColor(commodity.getColor());
        commodityEntity.setMaterial(commodity.getMaterial());
        commodityEntity.setHaveFlaw(commodity.getHaveFlaw());
        commodityEntity.setTyreSize(commodity.getTyreSize());
        commodityEntity.setHoleSpacing(commodity.getHoleSpacing());
        commodityEntity.setManufacturMode(commodity.getManufacturMode());
        commodityEntity.setLightType(commodity.getLightType());
        commodityEntity.setHubSize(commodity.getHubSize());
        commodityEntity.setSize(commodity.getSize());
        commodityEntity.setType(commodity.getType());
        commodityEntity.setFlaw(commodity.getFlaw());
        commodityEntity.setPosition(commodity.getPosition());
        commodityEntity.setCreateTime(new Date());
        commodityEntity.setUpdateTime(new Date());
        commodityDao.insertCommodity(commodityEntity);
        return commodityEntity;
    }

    @Override
    public List<CommodityCategoryVO> queryCommodityCategorys() {
        List<CommodityCategoryVO> commodityCategoryList = commodityDao.queryCommodityCategorys();
        return commodityCategoryList;
    }

    @Override
    public Page<CommodityVO> queryCommoditysByCategoryId(Page<CommodityVO> page, String commodityCategoryId) {
        page = commodityDao.queryCommoditysByCategoryId(page,commodityCategoryId);
        return page;
    }
}
