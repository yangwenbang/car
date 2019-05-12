package com.car.modules.car.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.car.common.utils.Query;
import com.car.modules.car.entity.TeacherEntity;
import com.car.modules.car.entity.vo.TeacherVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-22 19:04:25
 */
public interface TeacherDao extends BaseMapper<TeacherEntity> {

    public List<TeacherVO> strengSelectPage(Page<TeacherVO> page,@Param("ew") Wrapper<TeacherEntity> wrapper,@Param("teacherName") String teacherName);

}
