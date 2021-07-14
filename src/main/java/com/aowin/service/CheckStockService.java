package com.aowin.service;

import com.aowin.dao.CheckStockDao;
import com.aowin.pojo.CheckStock;
import com.aowin.pojo.PayRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CheckStockService {
    void insert(CheckStock checkStock);
    int countAll();
    List<PayRecord> findAll(Map<String, Object> params);
    List<PayRecord> findSome(@Param("orderCode")String orderCode, @Param("start")String start, @Param("end") String end, @Param("pay_type")String pay_type);
    float pay1Num(String date);
    float pay2Num(String date);
    int pay1Count(String date);
    int pay2Count(String date);
    List<PayRecord> stockCheckReportChange(String date);
}
