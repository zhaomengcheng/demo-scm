package com.aowin.controller;

import com.aowin.pojo.Category;
import com.aowin.response.QueryResult;
import com.aowin.response.Result;
import com.aowin.service.CategoryService;
import com.aowin.utils.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {
    @Resource
    private CategoryService categoryService;
    //
     @GetMapping("categorys")
        public QueryResult getAll(Integer currentPage, Integer pageSize, HttpServletRequest request) {

            Page page = new Page(currentPage, pageSize);
            int total = categoryService.countAll();
            Map<String, Object> params = new HashMap<>();
            params.put("first", page.getFirst());
            params.put("max", page.getMax());
            List<Category> list = categoryService.findAll(params);
            return QueryResult.ok(total, list);
        }

     @PostMapping("category")
        public Result save(String name,String remark) {
            categoryService.insert(name,remark);
            return Result.ok();
        }

    @PostMapping("category2")
    public Result update(Category category) {
        categoryService.update(category);
        return Result.ok();
    }
    @PostMapping("category3")
    public Result delete(String categoryId) {
        categoryService.delete(Integer.parseInt(categoryId));
        return Result.ok();
    }

     @PostMapping("getCategory")
        public Result getUser(String categoryId) {
         Category category=categoryService.getCategory(Integer.parseInt(categoryId));
         return Result.ok(category);
        }

    @PostMapping("findCategoryName")
    public Result findCategoryName() {
       List<String> list=categoryService.findCategoryName();
        return Result.ok(list);
    }
}
