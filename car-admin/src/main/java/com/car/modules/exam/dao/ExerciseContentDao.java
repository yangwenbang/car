package com.car.modules.car.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.car.modules.car.entity.ExerciseContentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-02-11 14:51:15
 */
public interface ExerciseContentDao extends BaseMapper<ExerciseContentEntity> {

    List<ExerciseContentEntity> strengSelectPage(Page<ExerciseContentEntity> page,@Param("sectionId") String sectionId);
}
