package com.car.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.car.exception.DAOException;
import com.car.vo.QualityShopVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface QualityShopDao {

	
	List<QualityShopVO> getQualityShops(@Param("pageId") int pageId,
			@Param("pageSize") int pageSize) throws DAOException;
}
