package com.aowin.controller;

import com.aowin.pojo.User;
import com.aowin.response.LoginResult;
import com.aowin.response.Result;
import com.aowin.service.UserService;
import com.aowin.utils.jwt.JwtUtils;
import com.aowin.utils.jwt.PassToken;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private UserService userService;
    @PassToken
    //用户登录
    @PostMapping("login")
    public LoginResult login(@Param("account") String account, @Param("password") String password) {
        System.out.println(account+"**********************************"+password);
        User user = userService.findByAccount(account, password);
        System.out.println("+++++++++++++++++++++++++"+user);
        if(user==null){
            return  LoginResult.error("账号或密码有误");
        }
        else if(user.getStatus()==1){
            return LoginResult.error("账号已被锁定，请联系管理员");
        }
        else {

            // // user = userService.login(username,password);
            //        // if(error) return Result.error('用户名或密码错');
                    String token = "Bearer " + JwtUtils.createToken(user.getAccount(), user.getName(), 60 * 60 * 2);
                    LoginResult r = new LoginResult();
                    r.setCode(200);
                    r.setMsg("成功");
                    r.setToken(token);
                    return r;
        }
    }

}

