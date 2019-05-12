package com.car.modules.car.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.car.modules.car.entity.ExerciseModelEntity;
import com.car.modules.car.entity.ProjectEntity;
import com.car.modules.car.service.ExerciseModelService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;

import com.car.modules.car.dao.ExerciseTypeDao;
import com.car.modules.car.entity.ExerciseTypeEntity;
import com.car.modules.car.service.ExerciseTypeService;


@Service("exerciseTypeService")
public class ExerciseTypeServiceImpl extends ServiceImpl<ExerciseTypeDao, ExerciseTypeEntity> implements ExerciseTypeService {


    @Autowired
    private ExerciseModelService exerciseModelService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Wrapper<ExerciseTypeEntity> wrapper = new EntityWrapper<ExerciseTypeEntity>();
        if (params.containsKey("exerciseName")) {
            String exerciseName = (String) params.get("exerciseName");
            wrapper = wrapper.like("exercise_name", exerciseName);
        }

        if (params.containsKey("exerciseType")) {
            if (params.get("exerciseType") != null) {
                Integer exerciseType = (Integer) params.get("exerciseType");
                wrapper = wrapper.eq("exercise_type", exerciseType);
            }
        }
        if (params.containsKey("modelId")) {
            if (params.get("modelId") != null) {
                Integer modelId = (Integer) params.get("modelId");
                wrapper = wrapper.eq("exercise_model_id", modelId);
            }
        }
        Page<ExerciseTypeEntity> page = this.selectPage(new Query<ExerciseTypeEntity>(params).getPage(), wrapper);
        Map<Long, ExerciseModelEntity> exerciseModelEntityMap = exerciseModelService.queryAllMaps();
        List<ExerciseTypeEntity> exerciseTypeEntities = page.getRecords();
        for (ExerciseTypeEntity item : exerciseTypeEntities) {
            if (exerciseModelEntityMap.containsKey(item.getExerciseModelId())) {
                item.setExerciseModel(exerciseModelEntityMap.get(item.getExerciseModelId()).getModelName());
            }
        }

        return new PageUtils(page);
    }

    @Override
    public List<ExerciseTypeEntity> queryAll() {
        return this.selectList(new EntityWrapper<ExerciseTypeEntity>());
    }

}
