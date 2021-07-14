package com.aowin.response;

import lombok.Data;

@Data
public class QueryResult {
    private int code;
    private String msg;
    private Object data;
    private int total;

    public static QueryResult ok(int total, Object data) {
        QueryResult r = new QueryResult();
        r.setCode(200);
        r.setMsg("成功");
        r.setData(data);
        r.setTotal(total);
        return r;
    }

}