package com.aowin.interceptors;

import com.aowin.utils.jwt.JwtException;
import com.aowin.utils.jwt.JwtUtils;
import com.aowin.utils.jwt.PassToken;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class LoginInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        System.out.println("...LoginInterceptor");

//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String name = headerNames.nextElement();
//            System.out.println(name + ":" + request.getHeader(name));
//        }

        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        //检查是否有PassToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        // 从http请求头中取出 token
        String token = request.getHeader("Authorization");

        if (StringUtils.isEmpty(token)) {
            throw new JwtException();
        }

        try {
            token = token.replace("Bearer ", "");
            DecodedJWT decodedJWT = JwtUtils.verifyToken(token);
            request.setAttribute("account", decodedJWT.getClaim("account").asString());
            request.setAttribute("name", decodedJWT.getClaim("name").asString());
        } catch (Exception e) {
            throw new JwtException();
        }
        return true;
    }
}
