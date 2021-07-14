package com.aowin.pojo;

import lombok.Data;

@Data
public class CheckStock {
    public  int stockId;
    public String productCode;
    public int originNum;
    public int realNum;
    public String stockTime;
    public String createUser;
    public String description;
    public String type;
}
