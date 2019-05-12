package com.car.service;

import java.util.List;

import com.car.exception.DAOException;
import com.car.vo.SectionVO;

import io.lettuce.core.dynamic.annotation.Param;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface SectionService {

	List<SectionVO> getSectionsByCourse(long courseId) throws DAOException;
	
	List<SectionVO> getSectionsByCondition(long projectId, int courseType, 
			int pageId) throws DAOException;

	
}
