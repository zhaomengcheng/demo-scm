package com.aowin.pojo;

import lombok.Data;

@Data
public class Category {
    private int categoryId;//产品类别序列号(主键) product的外键
    private String name;//名称
    private String remark;//描述

    @Override
    public String toString() {
        return "Category{" +
                "categoryID=" + categoryId +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
