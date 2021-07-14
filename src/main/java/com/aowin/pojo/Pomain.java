package com.aowin.pojo;

import lombok.Data;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Data
public class Pomain {
    private BigDecimal poId;//采购单编号
    private String     name;//供应商名称
    private String     account;//创建用户
    private String     createTime;//创建时间
    private Float      tipFee;//附加费用
    private Float      productTotal;//采购产品总价
    private Float      poTotal;//采购单总价格
    private String     payType;//付款方式
    private int        status;//处理状态
    private String     remark;
    private Float     prePayFee;
    @Resource
    private List<PoItem> poItems;

}
