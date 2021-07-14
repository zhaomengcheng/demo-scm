package com.aowin.pojo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class User {
    private String account;
    private String password;
    private String name;
    private String createDate;
    private int status;
    private ArrayList<String> modelName;

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", createDate='" + createDate + '\'' +
                ", status=" + status +
                ", modelName=" + modelName +
                '}';
    }
}

