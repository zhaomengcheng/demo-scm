package com.aowin.controller;

import com.aowin.pojo.User;
import com.aowin.response.QueryResult;
import com.aowin.response.Result;
import com.aowin.service.UserService;
import com.aowin.utils.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Resource
    private UserService userService;



    @PostMapping("getUser")
    public Result getUser(String account) {
        User user = userService.getUser(account);
        System.out.println(user);
        //User user = userService.findById(id);
        return Result.ok(user);
    }
    @GetMapping("users")
    public QueryResult getAll(Integer currentPage, Integer pageSize, HttpServletRequest request) {

        System.out.println(request.getAttribute("account"));
        Page page = new Page(currentPage, pageSize);
        int total = userService.countAll();
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<User> list = userService.findAll(params);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getModelName().size(); j++) {
                System.out.println("==============================================="+list.get(i).getModelName().get(j));
                if(list.get(i).getModelName().get(j).equals("admin")){
                    list.get(i).getModelName().set(j,"管理员");
                }
                if(list.get(i).getModelName().get(j).equals("purchase")){
                    list.get(i).getModelName().set(j,"采购");
                }
                if(list.get(i).getModelName().get(j).equals("stock")){
                    list.get(i).getModelName().set(j,"仓管");
                }
                if(list.get(i).getModelName().get(j).equals("sell")){
                    list.get(i).getModelName().set(j,"销售");
                }
                if(list.get(i).getModelName().get(j).equals("finance")){
                    list.get(i).getModelName().set(j,"财务");
                }

            }
        }
        return QueryResult.ok(total, list);
    }

    @PostMapping("user")
    public Result save(User user) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String id = sdf.format(date);
        user.setCreateDate(id);
        System.out.println("*******======="+user+"=======*******");
        userService.insert(user);
        return Result.ok();
    }

    @PostMapping("user2")
    public Result update(User user) {
        System.out.println("*******======="+user+"=======*******");
        userService.updateByAccount(user);
        return Result.ok();
    }

    @PostMapping("user3")
    public Result delete(String account) {
        System.out.println("*******======="+account+"=======*******");
        userService.deleteByAccount(account);
        return Result.ok();
    }

}
