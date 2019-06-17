package com.car.service.impl;

import java.util.Date;
import java.util.List;

import com.car.form.UpdateOldCommodityForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car.ApiConstants;
import com.car.dao.CommodityDao;
import com.car.entity.OldCommodity;
import com.car.exception.DAOException;
import com.car.form.OldCommodityForm;
import com.car.service.CommodityService;
import com.car.vo.CommodityVO;


@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;

    @Transactional(rollbackFor = Exception.class)
    public void insertCommodity(OldCommodityForm commodity) throws DAOException {
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
        commodityEntity.setCommodityNum(commodity.getCommodityNum());
        commodityEntity.setPrice(commodity.getPrice());
        commodityEntity.setPosition(commodity.getPosition());
        commodityEntity.setStartPrice(commodity.getStartPrice());
        commodityEntity.setFreight(commodity.getFreight());
        commodityEntity.setConcreteDescription(commodity.getConcreteDescription());
        commodityEntity.setOtherCategoryName(commodity.getOtherCategoryName());
        commodityEntity.setPublishUserHead(commodity.getPublishUserHead());
        commodityEntity.setPublishUserName(commodity.getPublishUserName());
        commodityEntity.setCreateTime(new Date());
        commodityEntity.setUpdateTime(new Date());
        commodityDao.insertCommodity(commodityEntity);
    }

    @Override
    public List<CommodityVO> queryCommoditysByCategoryId(long commodityCategoryId, int pageId) throws DAOException {
    	int pageSize = pageId * ApiConstants.PAGE_COUNT;
        return commodityDao.queryCommoditysByCategoryId(commodityCategoryId, pageSize, ApiConstants.PAGE_COUNT);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCommodityById(Long commodityById) throws DAOException {
        commodityDao.deleteCommodityById(commodityById);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCommodityById(UpdateOldCommodityForm commodityForm) throws DAOException {
        commodityDao.updateCommodityById(commodityForm);
    }

    @Override
    public List<CommodityVO> queryUserOldCommoditysByUserId(Long userId) throws DAOException {
        return commodityDao.queryUserOldCommoditysByUserId(userId);
    }

}
