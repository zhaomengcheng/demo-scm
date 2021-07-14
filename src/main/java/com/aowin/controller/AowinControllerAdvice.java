package com.aowin.controller;

import com.aowin.response.Result;
import com.aowin.utils.jwt.JwtException;
import org.apache.ibatis.exceptions.IbatisException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@ControllerAdvice
public class AowinControllerAdvice {

    @ExceptionHandler(JwtException.class)
    @ResponseBody
    public Result handleJwtException(JwtException e) {
        e.printStackTrace();
        Result result = new Result();
        result.setCode(401);
        result.setMsg("请先登录");
        return result;
    }


    @ExceptionHandler(IbatisException.class)
    @ResponseBody
    public Result doMyBatisException(Exception e) {
        e.printStackTrace();
        return Result.error("数据库错误");
    }

    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public Result doSqlException(Exception e) {
        e.printStackTrace();
        return Result.error("数据库错误");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception e) {
        e.printStackTrace();
        return Result.error("服务器错误");
    }

}