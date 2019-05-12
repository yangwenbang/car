package com.car.modules.car.controller;

import com.car.common.utils.JsonUtils;
import com.car.common.utils.PageCondition;
import com.car.common.utils.PageUtils;
import com.car.common.utils.R;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.CommodityEntity;
import com.car.modules.car.service.CommodityService;
import com.car.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.Date;


/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-14 15:46:53
 */
@RestController
@RequestMapping("car/commodity")
public class CommodityController extends AbstractController {
    @Autowired
    private CommodityService commodityService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestBody String data){
        PageCondition pageCondition= JsonUtils.readValue(data,PageCondition.class);
        Map<String, Object> params=pageCondition.transferToTargetMap();
        PageUtils page = commodityService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CommodityEntity commodity = commodityService.selectById(id);

        return R.ok().put("commodity", commodity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody String data){
        CommodityEntity commodityEntity = JsonUtils.readValue(data, CommodityEntity.class);
        ValidatorUtils.validateEntity(commodityEntity);
        if (commodityEntity.getId() == null || commodityEntity.getId() == 0) {
            commodityEntity.setReplayUsername(getUser().getUsername());
            commodityEntity.setEffective(1);
            commodityEntity.setReplayDate(new Date());
            commodityService.insert(commodityEntity);
        } else {
            commodityEntity.setReplayUsername(getUser().getUsername());
            commodityEntity.setUpdateTime(new Date());
            commodityService.updateAllColumnById(commodityEntity);//全部更新
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("car:commodity:update")
    public R update(@RequestBody CommodityEntity commodity){
        ValidatorUtils.validateEntity(commodity);
        commodityService.updateAllColumnById(commodity);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        commodityService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
