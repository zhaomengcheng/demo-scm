package com.aowin.service;

import com.aowin.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {
    void insert(User user);
    User findByAccount(@Param("account") String account, @Param("password") String password);
    int countAll();
    List<User> findAll(Map<String, Object> params);
    void deleteByAccount(String account);
    void updateByAccount(User user);
    User getUser(String account);
}
