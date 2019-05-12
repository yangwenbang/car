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

package com.car.modules.sys.controller;


import com.alibaba.fastjson.JSON;
import com.car.common.annotation.SysLog;
import com.car.common.utils.JsonUtils;
import com.car.common.utils.PageCondition;
import com.car.common.utils.PageUtils;
import com.car.common.utils.R;
import com.car.common.validator.Assert;
import com.car.common.validator.ValidatorUtils;
import com.car.common.validator.group.AddGroup;
import com.car.common.validator.group.UpdateGroup;
import com.car.modules.car.entity.AdvertisementEntity;
import com.car.modules.car.entity.vo.ModifyPwdVo;
import com.car.modules.sys.entity.SysUserEntity;
import com.car.modules.sys.service.SysUserRoleService;
import com.car.modules.sys.service.SysUserService;
import com.car.modules.sys.shiro.ShiroUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 所有用户列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:user:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysUserService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 保存用户
     */
    @SysLog("保存用户")
    @RequestMapping("/save/user")
    @RequiresPermissions("sys:user:save")
    public R saveUser(@RequestBody String data) {
        SysUserEntity sysUserEntity = JSON.parseObject(data, SysUserEntity.class);
        if (sysUserEntity.getUserId() == null || sysUserEntity.getUserId() == 0) {
            sysUserService.save(sysUserEntity);
        } else {
            sysUserService.update(sysUserEntity);//全部更新
        }
        return R.ok();
    }

    /**
     * 保存用户
     */
    @SysLog("保存用户")
    @RequestMapping("/save/status")
    @RequiresPermissions("sys:user:save")
    public R saveUserStatus(@RequestBody String data) {
        SysUserEntity sysUserEntity = JSON.parseObject(data, SysUserEntity.class);
        SysUserEntity sysUserEntitydb = sysUserService.selectById(sysUserEntity.getUserId());
        sysUserEntitydb.setStatus(sysUserEntity.getStatus());
        sysUserService.updateAllColumnById(sysUserEntitydb);//全部更新
        return R.ok();
    }


    /**
     * 所有用户列表
     */
    @RequestMapping("/today/count")
    @RequiresPermissions("sys:user:list")
    public R todayUsersCount() {
        int count = sysUserService.queryTodayUserCount();
        return R.ok().put("count", count);
    }

    /**
     * 所有用户列表
     */
    @RequestMapping("/list/condition")
    @RequiresPermissions("sys:user:list")
    public R listByCondition(@RequestBody String data) {
        PageCondition pageCondition = JsonUtils.readValue(data, PageCondition.class);
        Map<String, Object> params = pageCondition.transferToTargetMap();
        PageUtils page = sysUserService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 获取登录的用户信息
     */
    @RequestMapping("/info")
    public R info() {
        return R.ok().put("user", getUser());
    }

    /**
     * 修改登录用户密码
     */
    @SysLog("修改密码")
    @RequestMapping("/password")
    public R password(@RequestBody String data) {
        ModifyPwdVo vo= JsonUtils.readValue(data, ModifyPwdVo.class);
        String password=vo.getPassword();
        String newPassword=vo.getNewPassword();
        Assert.isBlank(newPassword, "新密码不为能空");
        password = ShiroUtils.sha256(password, getUser().getSalt());
        //新密码
        newPassword = ShiroUtils.sha256(newPassword, getUser().getSalt());
        //更新密码
        boolean flag = sysUserService.updatePassword(getUserId(), password, newPassword);
        if (!flag) {
            return R.error("原密码不正确");
        }

        return R.ok();
    }

    /**
     * 用户信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("sys:user:info")
    public R info(@PathVariable("userId") Long userId) {
        SysUserEntity user = sysUserService.selectById(userId);

        //获取用户所属的角色列表
        List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
        user.setRoleIdList(roleIdList);

        return R.ok().put("user", user);
    }

    /**
     * 保存用户
     */
    @SysLog("保存用户")
    @RequestMapping("/save")
    @RequiresPermissions("sys:user:save")
    public R save(@RequestBody SysUserEntity user) {
        ValidatorUtils.validateEntity(user, AddGroup.class);

        sysUserService.save(user);

        return R.ok();
    }

    /**
     * 修改用户
     */
    @SysLog("修改用户")
    @RequestMapping("/update")
    @RequiresPermissions("sys:user:update")
    public R update(@RequestBody SysUserEntity user) {
        ValidatorUtils.validateEntity(user, UpdateGroup.class);

        sysUserService.update(user);

        return R.ok();
    }

    /**
     * 删除用户
     */
    @SysLog("删除用户")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    public R delete(@RequestBody Long[] userIds) {
        if (ArrayUtils.contains(userIds, 1L)) {
            return R.error("系统管理员不能删除");
        }

        if (ArrayUtils.contains(userIds, getUserId())) {
            return R.error("当前用户不能删除");
        }

        sysUserService.deleteBatchIds(Arrays.asList(userIds));

        return R.ok();
    }


}
