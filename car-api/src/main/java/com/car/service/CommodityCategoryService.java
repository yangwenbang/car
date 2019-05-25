package com.car.service;

import java.util.List;

import com.car.exception.DAOException;
import com.car.vo.CommodityCategoryVO;

/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 21:32:24
 */
public interface CommodityCategoryService {
	
	List<CommodityCategoryVO> queryCommodityCategorys() throws DAOException;

}

