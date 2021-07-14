package com.aowin.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SoItem {
    private BigDecimal soId;
    private String productCode;
    private String productName;
    private String unitName;
    private double unitPrice;
    private int num;
    private double itemPrice;
}
