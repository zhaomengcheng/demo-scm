package com.aowin.service.impl;

import com.aowin.dao.UserDao;
import com.aowin.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements com.aowin.service.UserService{

    @Resource
    private UserDao userDao;
    @Override
    public void insert(User user) {
        userDao.insert(user);
        for (int i=0;i<user.getModelName().size();i++){
            userDao.insertModelName(user.getAccount(),user.getModelName().get(i));
        }
    }

    @Override
    public User findByAccount(@Param("account") String account, @Param("password") String password) {
        return userDao.findByAccount(account,password);
    }

    @Override
    public int countAll() {
        return userDao.countAll();
    }

    @Override
    public List<User> findAll(Map<String, Object> params) {
        return userDao.findAll(params);
    }

    @Override
    public void deleteByAccount(String account) {
        userDao.deleteModelName(account);
        userDao.deleteByAccount(account);
    }

    @Override
    public void updateByAccount(User user) {
        userDao.deleteModelName(user.getAccount());
        for (int i=0;i<user.getModelName().size();i++){
            userDao.insertModelName(user.getAccount(),user.getModelName().get(i));
        }
        userDao.updateByAccount(user);
//        String s="";
//        for (int i = 0; i < user.getModelName().size(); i++) {
//            if(user.getModelName().get(i).equals("admin")){
//                s="1001";
//                userDao.updateModelName(user.getAccount(),s);
//                break;
//            }
//            else if(user.getModelName().get(i).equals("purchase")){
//                s="1002";
//                userDao.updateModelName(user.getAccount(),s);
//            }
//            else if(user.getModelName().get(i).equals("sell")){
//                s="1003";
//                userDao.updateModelName(user.getAccount(),s);
//            }
//            else if(user.getModelName().get(i).equals("stock")){
//                s="1004";
//                userDao.updateModelName(user.getAccount(),s);
//            }
//            else if(user.getModelName().get(i).equals("finance")){
//                s="1005";
//                userDao.updateModelName(user.getAccount(),s);
//            }
//        }

    }

    @Override
    public User getUser(String account) {
        return userDao.getUser(account);
    }
}
