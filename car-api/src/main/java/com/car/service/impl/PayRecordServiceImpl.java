package com.car.service.impl;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car.dao.PayRecordDao;
import com.car.dao.SysInfoDao;
import com.car.dao.UserCoinDao;
import com.car.dao.UserDao;
import com.car.entity.PayRecord;
import com.car.entity.SysInfo;
import com.car.entity.UserCoin;
import com.car.exception.DAOException;
import com.car.service.PayRecordService;
import com.car.vo.PayRecordVO;
import com.car.vo.UserVO;

@Service("payRecordService")
public class PayRecordServiceImpl implements PayRecordService {
	private static final Logger log = LoggerFactory.getLogger(PayRecordServiceImpl.class);

	
	@Autowired
	private PayRecordDao payRecordDao;
	@Autowired
	private UserCoinDao usrCoinDao;
	@Autowired
	private SysInfoDao sysInfoDao;
	@Autowired
	private UserDao userDao;

	@Override
	public PayRecordVO findByUserAndOrderNo(long userId, String orderNo) throws DAOException {
		return payRecordDao.findByUserAndOrderNo(userId, orderNo);
	}

	@Override
	@Transactional
	public void savePayRecord(PayRecord payRecord) throws DAOException {
		payRecordDao.savePayRecord(payRecord);
	}
	
	@Override
	public long getMaxPayRecordId() throws DAOException {
		return payRecordDao.getMaxPayRecordId();
	}

	@Override
	@Transactional
	public void saveBuyInfo(String orderNo) throws DAOException {
		log.info("--------saveBuyInfo-----------" + orderNo);
		// payRecord
		PayRecordVO payRecord = payRecordDao.getPayRecordByOrderNo(orderNo, 0);
		log.info("--------payRecord-----------" + payRecord);
		if (payRecord == null) {
			throw new DAOException("can not find payRecord by orderNo" + orderNo);
		}
		
		payRecord.setPayStatus(1);
		payRecordDao.updatePayRecordStatus(payRecord);
		
		// userCoin
		String infoContent = "";
		long userId = payRecord.getUserId();
		UserVO user = userDao.findById(userId);
		UserCoin userCoin = usrCoinDao.getUserCoinEntityByUser(userId);
		if (userCoin == null) {
			userCoin = new UserCoin();
			userCoin.setUserId(userId);
			userCoin.setCoin(payRecord.getCoin());
			userCoin.setVersion(0);
			userCoin.setCreateTime(new Date());
			userCoin.setUpdateTime(new Date());
			usrCoinDao.saveUserCoin(userCoin);
			infoContent = "您充值成功！剩余学币为：" + payRecord.getCoin();
		} else {
			double newCoin = userCoin.getCoin() + payRecord.getCoin();
			userCoin.setCoin(newCoin);
			usrCoinDao.updateUserCoin(userCoin);
			infoContent = "您充值成功！剩余学币为：" + newCoin;
		}
		
		// sysInfo
		SysInfo sysInfo = new SysInfo();
		sysInfo.setUserId(userId);
//		sysInfo.setProjectId(projectId);
		sysInfo.setInfoContent(infoContent);
		sysInfo.setInfoType(0);
		sysInfo.setProduceUserName(user.getUserName());
		sysInfo.setProduceDate(new Date());
		sysInfoDao.saveSysInfo(sysInfo);
		
	}


	


}
