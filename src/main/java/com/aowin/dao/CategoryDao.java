package com.aowin.dao;

import com.aowin.pojo.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryDao {
    int countAll();
    List<Category> findAll(Map<String, Object> params);
    void insert(@Param("name")String name, @Param("remark")String remark);
    Category getCategory(int categoryId);
    void update(Category category);
    void delete(int categoryId);
    List<String> findCategoryName();
}
