package com.aowin.service.impl;

import com.aowin.dao.CategoryDao;
import com.aowin.pojo.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("categoryService")
public class CategoryServiceImpl implements com.aowin.service.CategoryService{
    @Resource
    private CategoryDao categoryDao;

    @Override
    public int countAll() {
        return categoryDao.countAll();
    }

    @Override
    public List<Category> findAll(Map<String, Object> params) {
        return categoryDao.findAll(params);
    }

    @Override
    public void insert(String name, String remark) {
        categoryDao.insert(name,remark);
    }

    @Override
    public Category getCategory(int categoryId) {
        return categoryDao.getCategory(categoryId);
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }

    @Override
    public void delete(int categoryId) {
        categoryDao.delete(categoryId);
    }

    @Override
    public List<String> findCategoryName() {
       return categoryDao.findCategoryName();
    }
}
