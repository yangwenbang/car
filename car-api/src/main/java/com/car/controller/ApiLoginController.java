package com.car.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.annotation.Login;
import com.car.common.utils.R;
import com.car.exception.DAOException;
import com.car.form.MobileLoginForm;
import com.car.form.WeChatLoginForm;
import com.car.service.TokenService;
import com.car.service.UserService;
import com.car.utils.Result;
import com.car.vo.UserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 登录接口
 *
 * @author wind
 */
@RestController
@RequestMapping("/api")
@Api(tags="登录接口")
public class ApiLoginController {
	private static final Logger log = LoggerFactory.getLogger(ApiLoginController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    
    @PostMapping("mobileLogin")
    @ApiOperation("用户手机登录接口(测试用)")
    public Result<UserVO> login(@ModelAttribute MobileLoginForm form){

        //用户登录
        UserVO user = null;
		try {
			user = userService.login(form);
		} catch (DAOException e) {
			log.error("login occur error ", e);
			return new Result<>(500, e.getMessage());
		}

        return new Result<>(user);
    }
    
    @PostMapping("weChatLogin")
    @ApiOperation("用户微信登录接口")
    public Result<UserVO> weChatLogin(@ModelAttribute WeChatLoginForm form){

        //用户登录
        UserVO user = null;
		try {
			user = userService.weChatLogin(form);
		} catch (Exception e) {
			log.error("login occur error ", e);
			return new Result<>(500, e.getMessage());
		}

        return new Result<>(user);
    }
    
    @Login
    @PostMapping("logout")
    public R logout(@RequestAttribute("userId") long userId){
        tokenService.expireToken(userId);
        return R.ok();
    }

}
