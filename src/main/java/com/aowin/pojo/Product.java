package com.aowin.pojo;

import lombok.Data;

@Data
public class Product {
    private String productCode;//产品编号
    private String categoryName;//产品类别名称
    private String name;//名称
    private String unitName;//数量单位
    private float price;//销售价
    private String createDate;//添加日期
    private String remark;//产品描述
    private int num;
    private int poNum;
    private int soNum;
    private int inStock;
    private int outStock;
}
