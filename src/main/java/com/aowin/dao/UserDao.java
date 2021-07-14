package com.aowin.dao;

import com.aowin.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    User getUser(String account);
    void insert(User user);
    void insertModelName(@Param("account") String account,@Param("modelName")  String modelName);
    User findByAccount(@Param("account") String account, @Param("password") String password);
    int countAll();
    List<User> findAll(Map<String, Object> params);
    void deleteByAccount(String account);
    void updateByAccount(User user);
    void updateModelName(String account,String modelName);
    void deleteModelName(String account);
}
