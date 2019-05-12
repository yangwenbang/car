package com.car.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.ChapterDao;
import com.car.exception.DAOException;
import com.car.service.ChapterService;
import com.car.vo.ChapterVO;

@Service("chapterService")
public class ChapterServiceImpl implements ChapterService {
	@Autowired
	private ChapterDao chapterDao;

	@Override
	public List<ChapterVO> getChaptersByCourse(long courseId) throws DAOException {
		return chapterDao.getChaptersByCourse(courseId);
	}


}
