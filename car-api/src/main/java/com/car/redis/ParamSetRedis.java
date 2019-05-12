package com.car.redis;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.car.common.utils.RedisApiKeys;
import com.car.common.utils.RedisUtils;
import com.car.exception.DAOException;
import com.car.service.ParamSetService;
import com.car.vo.ParamSetVO;

@Component
public class ParamSetRedis {
	
	private static final Logger log = LoggerFactory.getLogger(ParamSetRedis.class);

	@Autowired
	private RedisUtils redisUtils;
	
	private Lock lock = new ReentrantLock();
	
	public ParamSetVO getParamSet(ParamSetService paramSetService) throws DAOException {
		ParamSetVO paramSet = null;
		
		String key = RedisApiKeys.getParamSetKey();
		
		paramSet = redisUtils.get(key, ParamSetVO.class);
		
		if (paramSet != null) {
			log.info("get data from cache1-------");

			return paramSet;
					
		}
		
		lock.lock();
		
		try {
			
			paramSet = redisUtils.get(key, ParamSetVO.class);
			
			if (paramSet != null) {
				log.info("get data from cache2-------");
				
				return paramSet;
						
			}
			log.info("get data from db-------");
			
			paramSet = paramSetService.getParamSetVO();
			
			if (paramSet != null) {
				redisUtils.set(key, paramSet);
			}
		} finally {
			
			lock.unlock();
			
		}
		
		return paramSet;
	}
	
}
