package com.aowin.utils.jwt;

public class JwtException extends RuntimeException {
    public JwtException() {
        super("Token错误");
    }
}
