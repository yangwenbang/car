package com.car.modules.car.controller;

import com.car.common.utils.JsonUtils;
import com.car.common.utils.PageCondition;
import com.car.common.utils.PageUtils;
import com.car.common.utils.R;
import com.car.modules.car.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-01-23 00:54:45
 */
@RestController
@RequestMapping("car/msg")
public class MessageController {


    @Autowired
    private SubjectService subjectService;

    /**
     * 列表
     */
    @RequestMapping("/list/condition")
    public R listByCondition(@RequestBody String data) {
        PageCondition pageCondition = JsonUtils.readValue(data, PageCondition.class);
        Map<String, Object> params = pageCondition.transferToTargetMap();
        PageUtils page = subjectService.queryPage(params);
        return R.ok().put("page", page);
    }
}
