package com.car.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.common.utils.R;
import com.car.form.RegisterForm;
import com.car.service.UserService;

/**
 * 注册接口
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-26 17:27
 */
@RestController
@RequestMapping("/api")
public class ApiRegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public R register(@RequestBody RegisterForm form){
        //表单校验
//        ValidatorUtils.validateEntity(form);
//
//        UserEntity user = new UserEntity();
//        user.setMobile(form.getMobile());
//        user.setUsername(form.getMobile());
//        user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
//        user.setCreateTime(new Date());
//        userService.insert(user);

        return R.ok();
    }
}
