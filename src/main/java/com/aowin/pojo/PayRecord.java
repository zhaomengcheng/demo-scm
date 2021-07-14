package com.aowin.pojo;

import lombok.Data;

@Data
public class PayRecord {
    private int record_id;
    private String pay_time;
    private String pay_price;
    private String account;
    private String orderCode;
    private int pay_type;
}
