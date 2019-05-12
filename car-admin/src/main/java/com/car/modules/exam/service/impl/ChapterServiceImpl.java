package com.car.modules.car.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.ChapterDao;
import com.car.modules.car.entity.ChapterEntity;
import com.car.modules.car.service.ChapterService;


@Service("chapterService")
public class ChapterServiceImpl extends ServiceImpl<ChapterDao, ChapterEntity> implements ChapterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String courseId = (String) params.get("courseId");
        String find = (String) params.get("find");
        Page<ChapterEntity> page = this.selectPage(
                new Query<ChapterEntity>(params).getPage(),
                new EntityWrapper<ChapterEntity>().setSqlSelect("description", "chapter_name", "id").eq(StringUtils.isNotBlank(courseId), "course_id", courseId)
                        .like(StringUtils.isNotBlank(find), "chapter_name", find).orderBy("seq", false)
        );

        return new PageUtils(page);
    }

}
