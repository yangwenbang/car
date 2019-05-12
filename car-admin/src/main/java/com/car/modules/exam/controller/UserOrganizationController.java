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

import com.car.modules.car.entity.UserOrganizationEntity;
import com.car.modules.car.service.UserOrganizationService;
import com.car.common.utils.PageUtils;
import com.car.common.utils.R;



/**
 * 合作伙伴机构关联表
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-22 15:40:27
 */
@RestController
@RequestMapping("car/userorganization")
public class UserOrganizationController {
    @Autowired
    private UserOrganizationService userOrganizationService;

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("car:userorganization:info")
    public R info(@PathVariable("id") Long id){
        UserOrganizationEntity userOrganization = userOrganizationService.selectById(id);

        return R.ok().put("userOrganization", userOrganization);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("car:userorganization:save")
    public R save(@RequestBody UserOrganizationEntity userOrganization){
        userOrganizationService.insert(userOrganization);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("car:userorganization:update")
    public R update(@RequestBody UserOrganizationEntity userOrganization){
        ValidatorUtils.validateEntity(userOrganization);
        userOrganizationService.updateAllColumnById(userOrganization);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("car:userorganization:delete")
    public R delete(@RequestBody Long[] ids){
        userOrganizationService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
