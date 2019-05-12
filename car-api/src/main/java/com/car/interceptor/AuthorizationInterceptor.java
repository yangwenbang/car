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

package com.car.interceptor;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.car.annotation.Login;
import com.car.common.exception.RRException;
import com.car.common.utils.RedisUtils;
import com.car.entity.TokenEntity;
import com.car.jwt.JwtManager;
import com.car.jwt.TokenState;
import com.car.service.TokenService;

/**
 * 权限(Token)验证
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:38
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private RedisUtils redisUtils;

    public static final String USER_KEY = "userId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        }else{
            return true;
        }

        if(annotation == null){
            return true;
        }

        //从header中获取token
        String token = request.getHeader("token");
        //如果header中不存在token，则从参数中获取token
        if(StringUtils.isBlank(token)){
            token = request.getParameter("token");
        }

        //token为空
        if(StringUtils.isBlank(token)){
            throw new RRException("token不能为空");
        }

        //查询token信息
        Map<String, Object> resultMap = JwtManager.validToken(token);
        String state = (String)resultMap.get("state");
        if (TokenState.INVALID.toString().equals(state)) {
        	
        	throw new RRException("token不合法，请重新登录", 600); 
        	
        } else if (TokenState.EXPIRED.toString().equals(state)) {
        	
        	throw new RRException("token失效，请重新登录", 600); 
        	
        }
        
        
//        TokenEntity tokenEntity = tokenService.queryByToken(token);
//        if(tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()){
//            throw new RRException("token失效，请重新登录", 600); 
//        }

        //设置userId到request里，后续根据userId，获取用户信息
//        request.setAttribute(USER_KEY, tokenEntity.getUserId());

        return true;
    }
}
