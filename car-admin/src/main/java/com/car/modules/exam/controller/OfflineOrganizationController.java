package com.car.modules.car.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.car.common.utils.*;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.CityEntity;
import com.car.modules.car.entity.OfflineOrganizationEntity;
import com.car.modules.car.service.CityService;
import com.car.modules.car.service.OfflineOrganizationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;


/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-14 18:21:39
 */
@RestController
@RequestMapping("car/offlineorganization")
public class OfflineOrganizationController {
    @Autowired
    private OfflineOrganizationService offlineOrganizationService;

    @Autowired
    private CityService cityService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("car:offlineorganization:list")
    public R list(@RequestBody String data) {
        PageCondition pageCondition = JsonUtils.readValue(data, PageCondition.class);
        Map<String, Object> params = pageCondition.transferToTargetMap();
        PageUtils page = offlineOrganizationService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("car:offlineorganization:info")
    public R info(@PathVariable("id") Long id) {
        OfflineOrganizationEntity offlineOrganization = offlineOrganizationService.selectById(id);

        return R.ok().put("offlineOrganization", offlineOrganization);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("car:offlineorganization:save")
    public R save(@RequestBody String data) {
        OfflineOrganizationEntity offlineOrganizationEntity = JsonUtils.readValue(data, OfflineOrganizationEntity.class);
        ValidatorUtils.validateEntity(offlineOrganizationEntity);
        if (createOrganCode(offlineOrganizationEntity)) {
            if (offlineOrganizationEntity.getId() == null || offlineOrganizationEntity.getId() == 0) {
                offlineOrganizationEntity.setCreateTime(new Date());
                offlineOrganizationEntity.setStatus(1);
                offlineOrganizationEntity.setUpdateTime(new Date());
                offlineOrganizationService.insert(offlineOrganizationEntity);
            } else {
                offlineOrganizationEntity.setUpdateTime(new Date());
                offlineOrganizationService.updateAllColumnById(offlineOrganizationEntity);//全部更新
            }
            return R.ok();
        } else {
            return R.error("机构码生成失败");
        }
    }

    private boolean createOrganCode(OfflineOrganizationEntity offlineOrganizationEntity) {
        CityEntity cityEntity = cityService.selectById(offlineOrganizationEntity.getCityId());
        String py = StringUtil.getPinYinHeadChar(cityEntity.getCityName());
        int i = 0;
        while (true) {
            String code = ToolUtils.getRandomNumCode(6);
            String ocode = String.format("%s%s", py.toUpperCase(), code);
            int count = offlineOrganizationService.selectCount(new EntityWrapper<OfflineOrganizationEntity>().eq("organization_code", ocode));
            i++;
            if (count > 0) {
                if (i < 1000) {
                    continue;
                } else {
                    return false;
                }
            }
            offlineOrganizationEntity.setOrganizationCode(ocode);
            break;
        }
        return true;
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("car:offlineorganization:delete")
    public R delete(@RequestBody Long[] ids) {
        offlineOrganizationService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
