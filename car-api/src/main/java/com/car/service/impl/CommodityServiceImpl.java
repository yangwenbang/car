package com.car.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car.ApiConstants;
import com.car.common.utils.DateUtils;
import com.car.dao.CommodityDao;
import com.car.entity.OldCommodity;
import com.car.exception.DAOException;
import com.car.form.OldCommodityForm;
import com.car.form.UpdateOldCommodityForm;
import com.car.service.CommodityService;
import com.car.vo.CommodityVO;


@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;

    @Transactional(rollbackFor = Exception.class)
    public void insertCommodity(OldCommodityForm commodityForm) throws DAOException {
        OldCommodity commodityEntity = new OldCommodity();
        
        commodityEntity.setAddress(commodityForm.getAddress());
        commodityEntity.setCommodityCategoryId(commodityForm.getCommodityCategoryId());
        commodityEntity.setQualityShopId(commodityForm.getQualityShopId());
        commodityEntity.setCommodityName(commodityForm.getCommodityName());
        commodityEntity.setCommodityCode("0000");
        commodityEntity.setCommodityPicture(commodityForm.getCommodityPicture());
        commodityEntity.setDetailAddress(commodityForm.getDetailAddress());
        commodityEntity.setAuditStatus(0);
        commodityEntity.setConsignmentPrice(commodityForm.getConsignmentPrice());
        commodityEntity.setPublishUserId(commodityForm.getPublishUserId());
        commodityEntity.setDescription(commodityForm.getDescription());
        commodityEntity.setFreight(commodityForm.getFreight());
        commodityEntity.setLatitude(commodityForm.getLatitude());
        commodityEntity.setLongitude(commodityForm.getLatitude());
        commodityEntity.setPrice(commodityForm.getPrice());
        commodityEntity.setUseTimeLength(commodityForm.getUseTimeLength());
        
        String arrivalTimeString = commodityForm.getArrivalTime();
        if (StringUtils.isNotEmpty(arrivalTimeString)) {
        	Date arrivalTime = DateUtils.parseDate(arrivalTimeString);
        	commodityEntity.setArrivalTime(arrivalTime);
        }

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
