package com.car.modules.car.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.car.common.utils.PageUtils;
import com.car.common.utils.Query;
import com.car.modules.car.dao.CategoryDao;
import com.car.modules.car.entity.CategoryEntity;
import com.car.modules.car.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        Wrapper<CategoryEntity> wrapper = new EntityWrapper<CategoryEntity>();
        if (params.containsKey("categoryName")) {
            String categoryName = (String) params.get("categoryName");
            wrapper = wrapper.like("category_name", categoryName);
        }
        if (params.containsKey("projectId")) {
            if (params.get("projectId") != null) {
                Integer projectId = (Integer) params.get("projectId");
                if (projectId > 0) {
                    wrapper = wrapper.eq("project_id", projectId);
                }
            }
        }
        Page<CategoryEntity> page = this.selectPage(new Query<CategoryEntity>(params).getPage(), wrapper);
        return new PageUtils(page);
    }

}
