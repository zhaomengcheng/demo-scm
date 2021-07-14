package com.aowin.pojo;

import lombok.Data;

@Data
public class Customer {
    private String customerCode;
    private String name;
    private String password;
    private String contactor;//联系人
    private String address;
    private String postCode;//邮政编码
    private String tel;
    private String fax;//传真
    private String createDate;//创建日期
}
