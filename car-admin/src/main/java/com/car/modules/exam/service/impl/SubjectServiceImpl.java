package com.car.modules.car.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;
import com.car.modules.car.dao.SubjectDao;
import com.car.modules.car.entity.SubjectEntity;
import com.car.modules.car.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("subjectService")
public class SubjectServiceImpl extends ServiceImpl<SubjectDao, SubjectEntity> implements SubjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        Wrapper<SubjectEntity> wrapper = new EntityWrapper<SubjectEntity>();
        if (params.containsKey("subjectName")) {
            String subjectName = (String) params.get("subjectName");
            wrapper = wrapper.like("subject_name", subjectName);
        }
        if (params.containsKey("categoryId")) {
            if (params.get("categoryId") != null) {
                Integer categoryId = (Integer) params.get("categoryId");
                if (categoryId > 0) {
                    wrapper = wrapper.eq("category_id", categoryId);
                }
            }
        }
        Page<SubjectEntity> page = this.selectPage(new Query<SubjectEntity>(params).getPage(), wrapper);
        return new PageUtils(page);
    }

}
