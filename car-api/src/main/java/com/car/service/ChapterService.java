package com.car.service;

import java.util.List;

import com.car.exception.DAOException;
import com.car.vo.ChapterVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface ChapterService {

	List<ChapterVO> getChaptersByCourse(long courseId) throws DAOException;

	
}
