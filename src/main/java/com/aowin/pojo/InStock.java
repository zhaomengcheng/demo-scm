package com.aowin.pojo;

import lombok.Data;

@Data
public class InStock {
private String poId;
private String productCode;
private String name;
private int num;
private float itemPrice;
private String stockTime;

}
