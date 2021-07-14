package com.aowin.dao;

import com.aowin.pojo.InStock;
import com.aowin.pojo.Pomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PomainDao {
    int countAll();
    int countAll2();
    int countEnd1();
    int countEnd2();
    int countEnd3();
    int countIn1();
    int countIn2();
    int countIn3();
    int countOutMoney1();
    int countOutMoney2();
    int countOutMoney3();
    List<Pomain> findAll2(Map<String, Object> params);
    List<Pomain> findAll(Map<String, Object> params);
    List<Pomain> findEnd1(Map<String, Object> params);
    List<Pomain> findEnd2(Map<String, Object> params);
    List<Pomain> findEnd3(Map<String, Object> params);
    List<Pomain> findIn1(Map<String, Object> params);
    List<Pomain> findIn2(Map<String, Object> params);
    List<Pomain> findIn3(Map<String, Object> params);
    List<Pomain> findOutMoney1(Map<String, Object> params);
    List<Pomain> findOutMoney2(Map<String, Object> params);
    List<Pomain> findOutMoney3(Map<String, Object> params);
    List<Pomain> findSome(@Param("poId")String poId,@Param("status")String status,@Param("start")String start,@Param("end")String end);
    void insert(Pomain pomain);
    Pomain getPomain(String poId);
    Pomain getPomain2(String poId);
    void delete(@Param("poId")String poId);
    void end(@Param("poId")String poId,@Param("endUser")String endUser,@Param("endTime")String endTime);
    void in(@Param("poId")String poId,@Param("stockUser")String stockUser,@Param("stockTime")String stockTime);
    void outMoney(@Param("poId")String poId,@Param("payUser")String payUser,@Param("payTime")String payTime);
    void outMoney2(@Param("poId")String poId,@Param("payUser")String payUser,@Param("payTime")String payTime);
    void  insertSr(@Param("productCode")String productCode,@Param("orderCode")String orderCode,@Param("stockNum")int stockNum,@Param("stockUser")String stockUser,@Param("stockTime")String stockTime);
    void  insertSrC(@Param("productCode")String productCode,@Param("orderCode")String orderCode,@Param("stockNum")int stockNum,@Param("stockUser")String stockUser,@Param("stockTime")String stockTime);
    void insertPayC(@Param("payTime")String payTime,@Param("price")String price,@Param("poId")String poId,@Param("account")String account);
    void insertPayC2(@Param("payTime")String payTime,@Param("price")String price,@Param("poId")String poId,@Param("account")String account);
    int countPomainReportAll(String date);
    int countPomainReportEnd(String date);
    int totalPomainReport(String date);
    int payPomainReport(String date);
    List<Pomain> findPomainReport(String date);
    int findInStockReportCount();
    List<InStock> findInStockReportAll(Map<String, Object> params);
    List<InStock> findInStockReport(String date);
    int InStockReportCount(String date);
    int InStockReportNum(String date);
    int InStockReportItemPrice(String date);

}
