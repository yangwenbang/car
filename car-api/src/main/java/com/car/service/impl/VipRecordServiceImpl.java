package com.car.service.impl;


import static com.car.ApiConstants.ZERO;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car.ApiConstants;
import com.car.common.utils.DateUtils;
import com.car.dao.PayRecordDao;
import com.car.dao.SysInfoDao;
import com.car.dao.UserDao;
import com.car.dao.UserProjectDao;
import com.car.dao.VipContentDao;
import com.car.dao.VipRecordDao;
import com.car.entity.PayRecord;
import com.car.entity.SysInfo;
import com.car.entity.VipRecord;
import com.car.exception.DAOException;
import com.car.pay.alipay.AlipayUtils;
import com.car.service.VipRecordService;
import com.car.vo.UserProjectVO;
import com.car.vo.UserVO;
import com.car.vo.VipContentVO;
import com.car.vo.VipRecordVO;

@Service("vipRecordService")
public class VipRecordServiceImpl implements VipRecordService {
	@Autowired
	private VipRecordDao vipRecordDao;
	@Autowired
	private SysInfoDao sysInfoDao;
	@Autowired
	private UserProjectDao userProjectDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private VipContentDao vipContentDao;
	@Autowired
	private PayRecordDao payRecordDao;

	@Override
	public VipRecordVO findVipRecordByUserAndProject(long userId, long projectId) throws DAOException {
		return vipRecordDao.findVipRecordByUserAndProject(userId, projectId);
	}

	@Override
	@Transactional
	public String buyVipByProject(long userId, long vipContentId) throws DAOException {
		String returnVipEndDate = "";
		UserProjectVO userProject = userProjectDao.getUserNewestProjectByUser(userId);
		
		if (userProject == null) {
    		throw new DAOException("请先选择项目！");
    	}
		
		String infoContent = "";
		long projectId = userProject.getProjectId();
		VipContentVO vipContent = vipContentDao.findByPK(vipContentId);
		UserVO user = userDao.findById(userId);
		VipRecord vipRecord = vipRecordDao.findVipRecordEntityByUserAndProject(userId, projectId);
		Date nowDate = new Date();
		int vipDay = vipContent.getVipDay();
		Date vipEndDate = DateUtils.addDateDays(new Date(), vipDay);
		if (vipRecord == null) { // 第一次购买会员
			
			infoContent = "会员功能已经开通，有效期至 " + DateUtils.format(vipEndDate);
			vipRecord = new VipRecord();
			vipRecord.setUserId(userId);
			vipRecord.setUserName(user.getUserName());
			vipRecord.setProjectId(projectId);
			vipRecord.setVipDay(vipDay);
			vipRecord.setVipBeginDate(nowDate);
			vipRecord.setVipEndDate(vipEndDate);
			vipRecord.setVersion(0);
			vipRecord.setCreateTime(nowDate);
			vipRecord.setUpdateTime(nowDate);
			vipRecordDao.saveVipRecord(vipRecord);
			returnVipEndDate = DateUtils.format(vipEndDate);
			
		} else {
			
			if (vipRecord.getVipEndDate().before(nowDate)) { // 会员已过期
				vipRecord.setVipBeginDate(nowDate);
				vipRecord.setVipEndDate(vipEndDate);
			} else { // 上次购买的会员还没有到期
				Date newVipEndDate = DateUtils.addDateDays(vipRecord.getVipEndDate(), vipDay);
				vipRecord.setVipEndDate(newVipEndDate);
				vipRecord.setVipDay(vipDay);
				returnVipEndDate = DateUtils.format(newVipEndDate);
			}
			
			vipRecordDao.updateVipReocrd(vipRecord);
			
		}
		
		//payRecord
		PayRecord payRecord = new PayRecord();
		payRecord.setUserId(userId);
		payRecord.setUserMobile(user.getMobile());
		payRecord.setUserName(user.getUserName());
		payRecord.setCargoType(ApiConstants.ONE);
		payRecord.setPayOrReturn(ZERO);
		payRecord.setPayDate(new Date());
		payRecord.setCoin(vipContent.getVipMoney());
		payRecord.setPayType(ApiConstants.TWO);
		payRecord.setBank("");
		payRecord.setCardNum("");
		payRecord.setPayer(user.getUserName());
		payRecord.setOrderNo(AlipayUtils.getOrderNo());
		payRecord.setPayStatus(ApiConstants.ONE);
		payRecord.setVersion(ZERO);
		payRecordDao.savePayRecord(payRecord);
		
		// 消息
		SysInfo sysInfo = new SysInfo();
		sysInfo.setUserId(userId);
		sysInfo.setProjectId(projectId);
		sysInfo.setInfoContent(infoContent);
		sysInfo.setInfoType(0);
		sysInfo.setProduceUserName(user.getUserName());
		sysInfo.setProduceDate(new Date());
		sysInfoDao.saveSysInfo(sysInfo);
		
		return returnVipEndDate;
	}



}
