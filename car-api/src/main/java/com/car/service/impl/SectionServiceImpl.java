package com.car.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.ApiConstants;
import com.car.dao.SectionDao;
import com.car.exception.DAOException;
import com.car.service.SectionService;
import com.car.vo.SectionVO;

@Service("sectionService")
public class SectionServiceImpl implements SectionService {
	@Autowired
	private SectionDao sectionDao;

	@Override
	public List<SectionVO> getSectionsByCourse(long courseId) throws DAOException {
		return sectionDao.getSectionsByCourse(courseId);
	}

	@Override
	public List<SectionVO> getSectionsByCondition(long projectId, int courseType, int pageId)
			throws DAOException {
		
		int pageSize = pageId * ApiConstants.PAGE_COUNT;
		
		return sectionDao.getSectionsByCondition(projectId, courseType, pageSize, ApiConstants.PAGE_COUNT);
	}

}
