package com.car.modules.car.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.SectionDao;
import com.car.modules.car.entity.SectionEntity;
import com.car.modules.car.service.SectionService;


@Service("sectionService")
public class SectionServiceImpl extends ServiceImpl<SectionDao, SectionEntity> implements SectionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String chapterId = (String) params.get("chapterId");
        String find = (String) params.get("find");
        Page<SectionEntity> page = this.selectPage(
                new Query<SectionEntity>(params).getPage(),
                new EntityWrapper<SectionEntity>().eq(StringUtils.isNotBlank(chapterId),"chapter_id",chapterId)
                        .like(StringUtils.isNotBlank(find),"section_name",find).orderBy("seq",false)
        );

        return new PageUtils(page);
    }

}
