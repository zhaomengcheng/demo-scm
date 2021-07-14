package com.aowin.pojo;

import lombok.Data;

@Data
public class OutStock {
    private String soId;
    private String productCode;
    private String name;
    private int num;
    private float itemPrice;
    private String stockTime;
}
