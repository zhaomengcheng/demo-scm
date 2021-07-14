package com.aowin.service;

import com.aowin.pojo.OutStock;
import com.aowin.pojo.Somain;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SomainService {
    int countAll();
    int countAll2();
    int countEnd1();
    int countEnd2();
    int countEnd3();
    int countOut1();
    int countOut2();
    int countOut3();
    int countInMoney1();
    int countInMoney2();
    int countInMoney3();
    List<Somain> findAll2(Map<String, Object> params);
    List<Somain> findAll(Map<String, Object> params);
    List<Somain> findEnd1(Map<String, Object> params);
    List<Somain> findEnd2(Map<String, Object> params);
    List<Somain> findEnd3(Map<String, Object> params);
    List<Somain> findOut1(Map<String, Object> params);
    List<Somain> findOut2(Map<String, Object> params);
    List<Somain> findOut3(Map<String, Object> params);
    List<Somain> findInMoney1(Map<String, Object> params);
    List<Somain> findInMoney2(Map<String, Object> params);
    List<Somain> findInMoney3(Map<String, Object> params);
    List<Somain> findSome(@Param("soId")String soId,@Param("status")String status,@Param("start")String start,@Param("end")String end);
    void insert(Somain somain);
    Somain getSomain(String soId);
    Somain getSomain2(String soId);
    void delete(@Param("soId")String soId);
    void end(@Param("soId")String soId,@Param("endUser")String endUser,@Param("endTime")String endTime);
    void out(@Param("soId")String soId,@Param("stockUser")String stockUser,@Param("stockTime")String stockTime);
    void inMoney(@Param("soId")String soId,@Param("payUser")String payUser,@Param("payTime")String payTime);
    void inMoney2(@Param("soId")String soId,@Param("payUser")String payUser,@Param("payTime")String payTime);
    void  insertSr(@Param("productCode")String productCode,@Param("orderCode")String orderCode,@Param("stockNum")int stockNum,@Param("stockUser")String stockUser,@Param("stockTime")String stockTime);
    void  insertSrC(@Param("productCode")String productCode,@Param("orderCode")String orderCode,@Param("stockNum")int stockNum,@Param("stockUser")String stockUser,@Param("stockTime")String stockTime);
    void insertPayC(@Param("payTime")String payTime,@Param("price")String price,@Param("soId")String soId,@Param("account")String account);
    void insertPayC2(@Param("payTime")String payTime,@Param("price")String price,@Param("soId")String soId,@Param("account")String account);
    int countSomainReportAll(String date);
    int countSomainReportEnd(String date);
    int totalSomainReport(String date);
    int paySomainReport(String date);
    List<Somain> findSomainReport(String date);
    int findOutStockReportCount();
    List<OutStock> findOutStockReportAll(Map<String, Object> params);
    List<OutStock> findOutStockReport(String date);
    int OutStockReportCount(String date);
    int OutStockReportNum(String date);
    int OutStockReportItemPrice(String date);


}
