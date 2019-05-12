package com.car.dao;

import java.util.List;

import com.car.exception.DAOException;
import com.car.vo.SectionVO;

import io.lettuce.core.dynamic.annotation.Param;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface SectionDao {

	List<SectionVO> getSectionsByCourse(long courseId) throws DAOException;
	
	List<SectionVO> getSectionsByCondition(@Param("projectId") long projectId,
			@Param("courseType") int courseType,
			@Param("pageId") int pageId,
			@Param("pageSize") int pageSize) throws DAOException;
	
}
