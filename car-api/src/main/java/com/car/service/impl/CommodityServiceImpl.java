package com.car.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import com.car.form.UpdateOldCommodityForm;

import org.apache.commons.beanutils.BeanUtils;
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
    public void insertCommodity(OldCommodityForm commodityForm) throws DAOException {
        OldCommodity commodityEntity = new OldCommodity();
        
        try {
			BeanUtils.copyProperties(commodityEntity, commodityForm);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
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
