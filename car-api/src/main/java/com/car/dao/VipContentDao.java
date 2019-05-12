package com.car.dao;

import java.util.List;

import com.car.exception.DAOException;
import com.car.vo.VipContentVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface VipContentDao {

	List<VipContentVO> getVipContentsByProject(long projectId) throws DAOException;
	
	VipContentVO findByPK(long vipContentId) throws DAOException;
}
