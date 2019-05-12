package com.car.modules.car.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;
import com.car.modules.car.dao.NewMsgDao;
import com.car.modules.car.entity.NewMsgEntity;
import com.car.modules.car.service.NewMsgService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("newMsgService")
public class NewMsgServiceImpl extends ServiceImpl<NewMsgDao, NewMsgEntity> implements NewMsgService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        Wrapper<NewMsgEntity> wrapper = new EntityWrapper<NewMsgEntity>();
        if (params.containsKey("msgName")) {
            String msgName = (String) params.get("msgName");
            wrapper = wrapper.like("msg_name", msgName);
        }
        if (params.containsKey("msgType")) {
            if (params.get("msgType") != null) {
                Integer msgType = (Integer) params.get("msgType");
                if (msgType > 0) {
                    wrapper = wrapper.eq("msg_type_id", msgType);
                }
            }
        }
        if (params.containsKey("projectId")) {
            if (params.get("projectId") != null) {
                Integer projectId = (Integer) params.get("projectId");
                if (projectId > 0) {
                    wrapper = wrapper.eq("project_id", projectId);
                }
            }
        }
        Page<NewMsgEntity> page = this.selectPage(new Query<NewMsgEntity>(params).getPage(), wrapper);
        return new PageUtils(page);
    }

}
