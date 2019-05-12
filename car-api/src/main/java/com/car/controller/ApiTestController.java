package com.car.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.annotation.Login;
import com.car.common.utils.R;
import com.car.entity.UserEntity;

/**
 * 测试接口
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api")
public class ApiTestController {

    @Login
    @GetMapping("userInfo")
    //@ApiOperation(value="获取用户信息", response=UserEntity.class)
    public R userInfo( UserEntity user){
        return R.ok().put("user", user);
    }

    @Login
    @GetMapping("userId")
    public R userInfo(Integer userId){
        return R.ok().put("userId", userId);
    }

    @GetMapping("notToken")
    //@ApiOperation("忽略Token验证测试")
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。");
    }

}
