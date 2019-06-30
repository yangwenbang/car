package com.car.dao;

import com.car.entity.SysInfo;
import com.car.exception.DAOException;
import com.car.vo.SysInfoVO;

import java.util.List;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface SysInfoDao {

	void saveSysInfo(SysInfo sysInfo) throws DAOException;

    List<SysInfoVO> queryUserInfosByUserId(Long userId) throws DAOException;

    void deleteUserInfoById(Long sysInfoId) throws DAOException;
}
