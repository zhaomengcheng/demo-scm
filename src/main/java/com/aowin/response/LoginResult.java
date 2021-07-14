package com.aowin.response;

import lombok.Data;

@Data
public class LoginResult {
    private int code;
    private String msg;
    private Object data;
    private String token;
    public static LoginResult error(String msg) {
        LoginResult r = new LoginResult();
        r.setCode(500);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }
    public static LoginResult ok(String msg) {
        LoginResult r = new LoginResult();
        r.setCode(200);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }
}

