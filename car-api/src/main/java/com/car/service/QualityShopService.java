package com.car.service;

import java.util.List;

import com.car.exception.DAOException;
import com.car.vo.QualityShopVO;


/**
 *
 * @author wind
 */
public interface QualityShopService {


	List<QualityShopVO> getQualityShops(int pageId) throws DAOException;


}

