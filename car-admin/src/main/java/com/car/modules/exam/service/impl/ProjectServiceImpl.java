package com.car.modules.car.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.car.modules.car.entity.ExerciseModelEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.ProjectDao;
import com.car.modules.car.entity.ProjectEntity;
import com.car.modules.car.service.ProjectService;


@Service("projectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectDao, ProjectEntity> implements ProjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Wrapper<ProjectEntity> wrapper = new EntityWrapper<ProjectEntity>();
        if (params.containsKey("projectName")) {
            String projectName = (String) params.get("projectName");
            wrapper = wrapper.like("project_name", projectName);
        }
        Page<ProjectEntity> page = this.selectPage(new Query<ProjectEntity>(params).getPage(), wrapper);
        return new PageUtils(page);
    }

    @Override
    public List<ProjectEntity> selectList() {
        return this.selectList(new EntityWrapper<ProjectEntity>());
    }

    @Override
    public Map<Long, ProjectEntity> selectMaps() {
        Map<Long, ProjectEntity> projectEntityMap = new HashMap<>();
        List<ProjectEntity> projectEntities = this.selectList(new EntityWrapper<ProjectEntity>());
        for (ProjectEntity item : projectEntities) {
            if (projectEntityMap.containsKey(item.getId()) == false) {
                projectEntityMap.put(item.getId(), item);
            }
        }
        return projectEntityMap;
    }

}
