package com.car.modules.car.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.ExerciseContentDao;
import com.car.modules.car.entity.ExerciseContentEntity;
import com.car.modules.car.service.ExerciseContentService;


@Service("exerciseContentService")
public class ExerciseContentServiceImpl extends ServiceImpl<ExerciseContentDao, ExerciseContentEntity> implements ExerciseContentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String sectionId = (String) params.get("sectionId");
        Page<ExerciseContentEntity> page = this.selectPage(
                new Query<ExerciseContentEntity>(params).getPage(),
                new EntityWrapper<ExerciseContentEntity>().eq(StringUtils.isNotBlank(sectionId),"section_id",sectionId)
                        .orderBy("seq",false)
        );
        page = page.setRecords(this.baseMapper.strengSelectPage(page,sectionId));
        return new PageUtils(page);
    }

    @Override
    public PageUtils strengSelectPage(Map<String, Object> params) {
        String sectionId = (String) params.get("sectionId");
        Page<ExerciseContentEntity> page = new Query<ExerciseContentEntity>(params).getPage();
        page = page.setRecords(this.baseMapper.strengSelectPage(page,sectionId));
        return new PageUtils(page);
    }

}
