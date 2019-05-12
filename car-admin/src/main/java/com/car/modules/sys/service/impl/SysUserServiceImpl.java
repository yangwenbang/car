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

package com.car.modules.sys.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.annotation.DataFilter;
import com.car.common.utils.*;
import com.car.modules.sys.dao.SysUserDao;
import com.car.modules.sys.entity.SysDeptEntity;
import com.car.modules.sys.entity.SysUserEntity;
import com.car.modules.sys.service.SysDeptService;
import com.car.modules.sys.service.SysUserRoleService;
import com.car.modules.sys.service.SysUserService;
import com.car.modules.sys.shiro.ShiroUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 系统用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:46:09
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysDeptService sysDeptService;

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return baseMapper.queryAllMenuId(userId);
    }

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {

        Wrapper<SysUserEntity> wrapper = new EntityWrapper<SysUserEntity>()
                .addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String) params.get(Constant.SQL_FILTER));

        if (params.containsKey("userName")) {
            String userName = (String) params.get("userName");
            if (StringUtil.hasValue(userName)) {
                wrapper = wrapper.like("username", userName);
            }
        }
        if (params.containsKey("phone")) {
            String mobile = (String) params.get("phone");
            if (StringUtil.hasValue(mobile)) {
                wrapper = wrapper.like("mobile", mobile);
            }
        }
        if(params.containsKey("status")){
            if (params.get("status")!=null) {
                Integer status=(Integer)params.get("status");
                wrapper = wrapper.eq("status", status);
            }
        }

        if (params.containsKey("startTime")) {
            String startTime = (String) params.get("startTime");
            if (StringUtil.hasValue(startTime)) {
                wrapper = wrapper.ge("create_time", startTime);
            }
        }
        if (params.containsKey("endTime")) {
            String endTime = (String) params.get("endTime");
            if (StringUtil.hasValue(endTime)) {
                wrapper = wrapper.le("create_time", endTime);
            }
        }

        Page<SysUserEntity> page = this.selectPage(new Query<SysUserEntity>(params).getPage(), wrapper);

        for (SysUserEntity sysUserEntity : page.getRecords()) {
            SysDeptEntity sysDeptEntity = sysDeptService.selectById(sysUserEntity.getDeptId());
            String deptName = sysDeptEntity == null ? "" : sysDeptEntity.getName();
            sysUserEntity.setDeptName(deptName);
        }

        return new PageUtils(page);
    }

    /**
     * 查询今日注册用户
     *
     * @return
     */
    @Override
    public int queryTodayUserCount() {
        int count= this.selectCount(new EntityWrapper<SysUserEntity>().between("create_time", DateUtils.getTodayMin(),DateUtils.getTodayMax()));
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysUserEntity user) {
        user.setCreateTime(new Date());
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setSalt(salt);
        user.setUserType(2);
        user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
        this.insert(user);

        //保存用户与角色关系
        sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysUserEntity user) {
        if (StringUtils.isBlank(user.getPassword())) {
            user.setPassword(null);
        } else {
            SysUserEntity userEntity = this.selectById(user.getUserId());
            user.setPassword(ShiroUtils.sha256(user.getPassword(), userEntity.getSalt()));
        }
        this.updateById(user);

        //保存用户与角色关系
        sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
    }


    @Override
    public boolean updatePassword(Long userId, String password, String newPassword) {
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setPassword(newPassword);
        return this.update(userEntity,
                new EntityWrapper<SysUserEntity>().eq("user_id", userId).eq("password", password));
    }

}
