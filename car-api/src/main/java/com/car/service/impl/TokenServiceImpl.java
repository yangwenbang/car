/**
 * Copyright 2018 人人开源 http://www.car.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.car.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.RedisUtils;
import com.car.dao.TokenDao;
import com.car.entity.TokenEntity;
import com.car.jwt.JwtManager;
import com.car.service.TokenService;


@Service("tokenService")
public class TokenServiceImpl extends ServiceImpl<TokenDao, TokenEntity> implements TokenService {
	/**
	 * 48小时后过期
	 */
	private final static int EXPIRE = 3600 * 48;
	
	@Autowired
	private RedisUtils redisUtils;

	@Override
	public TokenEntity queryByToken(String token) {
		return this.selectOne(new EntityWrapper<TokenEntity>().eq("token", token));
	}

	@Override
	public TokenEntity createToken(long userId) {
		//当前时间
		Date now = new Date();
		//过期时间
		long expireLength = now.getTime() + EXPIRE * 1000;
		Date expireTime = new Date(expireLength);

		//生成token
//		String token = generateToken();
		
		// jwt
		Map<String, Object> payload = new HashMap<>();
		Date date = new Date();
		payload.put("userId", userId);// 用户id
		payload.put("iat", date.getTime());// 生成时间:当前
		payload.put("ext", expireLength);
		String token = JwtManager.createToken(payload);

		//保存或更新用户token
		TokenEntity tokenEntity = new TokenEntity();
		tokenEntity.setUserId(userId);
		tokenEntity.setToken(token);
		tokenEntity.setUpdateTime(now);
		tokenEntity.setExpireTime(expireTime);
		this.insertOrUpdate(tokenEntity);
		
		return tokenEntity;
	}

	@Override
	public void expireToken(long userId){
		Date now = new Date();

		TokenEntity tokenEntity = new TokenEntity();
		tokenEntity.setUserId(userId);
		tokenEntity.setUpdateTime(now);
		tokenEntity.setExpireTime(now);
		this.insertOrUpdate(tokenEntity);
	}

	private String generateToken(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
