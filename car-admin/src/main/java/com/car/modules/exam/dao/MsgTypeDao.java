package com.car.modules.car.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.car.modules.car.entity.ExerciseContentEntity;
import com.car.modules.car.entity.MsgTypeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-13 11:18:40
 */
public interface MsgTypeDao extends BaseMapper<MsgTypeEntity> {
    List<MsgTypeEntity> queryWithProject(Page<MsgTypeEntity> page);
}
