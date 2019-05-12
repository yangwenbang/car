package com.car.modules.car.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;
import com.car.modules.car.dao.ExerciseModelDao;
import com.car.modules.car.entity.ExerciseModelEntity;
import com.car.modules.car.entity.ProjectEntity;
import com.car.modules.car.service.ExerciseModelService;
import com.car.modules.car.service.ProjectService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("exerciseModelService")
public class ExerciseModelServiceImpl extends ServiceImpl<ExerciseModelDao, ExerciseModelEntity> implements ExerciseModelService {

    @Autowired
    private ProjectService projectServices;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Map<Long, ProjectEntity> projectEntityMap = projectServices.selectMaps();

        Wrapper<ExerciseModelEntity> wrapper = new EntityWrapper<ExerciseModelEntity>();
        if (params.containsKey("modelName")) {
            String modelName = (String) params.get("modelName");
            wrapper = wrapper.like("model_name", modelName);
        }
        if (params.containsKey("projectId")) {
            if(params.get("projectId")!=null) {
                Integer projectId = (Integer) params.get("projectId");
                if (projectId > 0) {
                    wrapper = wrapper.eq("project_id", projectId);
                }
            }
        }

        Page<ExerciseModelEntity> page = this.selectPage(new Query<ExerciseModelEntity>(params).getPage(), wrapper);

        List<ExerciseModelEntity> exerciseModelEntities = page.getRecords();
        for (ExerciseModelEntity item : exerciseModelEntities) {
            if (projectEntityMap.containsKey(item.getProjectId())) {
                item.setProjectName(projectEntityMap.get(item.getProjectId()).getProjectName());
            }
        }

        return new PageUtils(page);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<ExerciseModelEntity> queryAll() {
        return this.selectList(new EntityWrapper<ExerciseModelEntity>());
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public Map<Long, ExerciseModelEntity> queryAllMaps() {
        Map<Long, ExerciseModelEntity> exerciseModelEntityMap = new HashMap<>();
        List<ExerciseModelEntity> exerciseModelEntities = this.selectList(new EntityWrapper<ExerciseModelEntity>());
        for (ExerciseModelEntity item : exerciseModelEntities) {
            if (exerciseModelEntityMap.containsKey(item.getId()) == false) {
                exerciseModelEntityMap.put(item.getId(), item);
            }
        }
        return exerciseModelEntityMap;
    }

    @Override
    public List<ExerciseModelEntity> queryListAll() {
        Map<Long, ProjectEntity> projectEntityMap = projectServices.selectMaps();
        List<ExerciseModelEntity> exerciseModelEntities = this.selectList(new EntityWrapper<ExerciseModelEntity>());
        for (ExerciseModelEntity item : exerciseModelEntities) {
            if (projectEntityMap.containsKey(item.getProjectId())) {
                item.setProjectName(projectEntityMap.get(item.getProjectId()).getProjectName());
            }
        }
        return exerciseModelEntities;
    }


}
