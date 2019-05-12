package com.car.dao;

import com.car.exception.DAOException;
import com.car.vo.CategoryVO;

/**
 * @author wind
 * @date 2019-01-9 22:28:06
 */
public interface CategoryDao {

	CategoryVO findCategoryByCategoryId(long categoryId) throws DAOException;
}
