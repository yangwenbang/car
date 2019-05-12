package com.car.modules.car.controller;

import java.util.Arrays;
import java.util.Map;

import com.car.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.modules.car.entity.UserIntroduceEntity;
import com.car.modules.car.service.UserIntroduceService;
import com.car.common.utils.PageUtils;
import com.car.common.utils.R;



/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-25 21:51:02
 */
@RestController
@RequestMapping("car/userintroduce")
public class UserIntroduceController {
    @Autowired
    private UserIntroduceService userIntroduceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("car:userintroduce:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userIntroduceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("car:userintroduce:info")
    public R info(@PathVariable("id") Long id){
        UserIntroduceEntity userIntroduce = userIntroduceService.selectById(id);

        return R.ok().put("userIntroduce", userIntroduce);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("car:userintroduce:save")
    public R save(@RequestBody UserIntroduceEntity userIntroduce){
        userIntroduceService.insert(userIntroduce);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("car:userintroduce:update")
    public R update(@RequestBody UserIntroduceEntity userIntroduce){
        ValidatorUtils.validateEntity(userIntroduce);
        userIntroduceService.updateAllColumnById(userIntroduce);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("car:userintroduce:delete")
    public R delete(@RequestBody Long[] ids){
        userIntroduceService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
