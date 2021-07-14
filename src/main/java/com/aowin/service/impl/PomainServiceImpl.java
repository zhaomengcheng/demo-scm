package com.aowin.service.impl;

import com.aowin.dao.PoItemDao;
import com.aowin.dao.PomainDao;
import com.aowin.dao.ProductDao;
import com.aowin.pojo.InStock;
import com.aowin.pojo.PoItem;
import com.aowin.pojo.Pomain;
import com.aowin.service.PomainService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("pomainservice")
public class PomainServiceImpl implements PomainService {
    @Resource
    private PomainDao pomainDao;
    @Resource
    private PoItemDao poItemDao;
    @Resource
    private ProductDao productDao;

    @Override
    public int countAll() {
        return pomainDao.countAll();
    }

    @Override
    public int countAll2() {
        return pomainDao.countAll2();
    }

    @Override
    public int countEnd1() {
        return pomainDao.countEnd1();
    }

    @Override
    public int countEnd2() {
        return pomainDao.countEnd2();
    }

    @Override
    public int countEnd3() {
        return pomainDao.countEnd3();
    }

    @Override
    public int countIn1() {
        return pomainDao.countIn1();
    }

    @Override
    public int countIn2() {
        return pomainDao.countIn2();
    }

    @Override
    public int countIn3() {
        return pomainDao.countIn3();
    }

    @Override
    public int countOutMoney1() {
        return pomainDao.countOutMoney1();
    }

    @Override
    public int countOutMoney2() {
        return pomainDao.countOutMoney2();
    }

    @Override
    public int countOutMoney3() {
        return pomainDao.countOutMoney3();
    }

    @Override
    public List<Pomain> findOutMoney1(Map<String, Object> params) {
        return pomainDao.findOutMoney1(params);
    }

    @Override
    public List<Pomain> findOutMoney2(Map<String, Object> params) {
        return pomainDao.findOutMoney2(params);
    }

    @Override
    public List<Pomain> findOutMoney3(Map<String, Object> params) {
        return pomainDao.findOutMoney3(params);
    }

    @Override
    public List<Pomain> findAll2(Map<String, Object> params) {
        return pomainDao.findAll2(params);
    }

    @Override
    public List<Pomain> findAll(Map<String, Object> params) {
        return pomainDao.findAll(params);
    }

    @Override
    public List<Pomain> findEnd1(Map<String, Object> params) {
        return pomainDao.findEnd1(params);
    }

    @Override
    public List<Pomain> findEnd2(Map<String, Object> params) {
        return pomainDao.findEnd2(params);
    }

    @Override
    public List<Pomain> findEnd3(Map<String, Object> params) {
        return pomainDao.findEnd3(params);
    }

    @Override
    public List<Pomain> findIn1(Map<String, Object> params) {
        return pomainDao.findIn1(params);
    }

    @Override
    public List<Pomain> findIn2(Map<String, Object> params) {
        return pomainDao.findIn2(params);
    }

    @Override
    public List<Pomain> findIn3(Map<String, Object> params) {
        return pomainDao.findIn3(params);
    }

    @Override
    public List<Pomain> findSome(@Param("poId")String poId,@Param("status")String status,@Param("start")String start,@Param("end")String end) {
        return pomainDao.findSome(poId,status,start,end);
    }

    @Override
    public void insert(Pomain pomain) {
        List<PoItem> poItems = pomain.getPoItems();
        for (int i = 0; i < poItems.size(); i++) {
            int poNum = productDao.getPoNum(poItems.get(i).getProductCode());
            productDao.updatePoNum(poNum+poItems.get(i).getNum(),poItems.get(i).getProductCode());
        }
        pomainDao.insert(pomain);
        for (int i = 0; i < poItems.size(); i++) {
            poItemDao.insert(poItems.get(i));
        }

    }

    @Override
    public Pomain getPomain(String poId) {
        return pomainDao.getPomain(poId);
    }

    @Override
    public Pomain getPomain2(String poId) {
        return pomainDao.getPomain2(poId);
    }

    @Override
    public void delete(@Param("poId")String poId) {
        List<PoItem> poItems=poItemDao.getPoItems(poId);
        for (int i = 0; i < poItems.size(); i++) {
            int poNum=productDao.getPoNum(poItems.get(i).getProductCode());
            productDao.updatePoNum(poNum-poItems.get(i).getNum(),poItems.get(i).getProductCode());
        }
        poItemDao.delete(poId);
        pomainDao.delete(poId);
    }

    @Override
    public void end(String poId, String endUser, String endTime) {
        pomainDao.end(poId,endUser,endTime);
    }

    @Override
    public void in(String poId, String stockUser, String stockTime) {
        List<PoItem> poItems=poItemDao.getPoItems(poId);
        for (int i = 0; i < poItems.size(); i++) {
            int poNum=productDao.getPoNum(poItems.get(i).getProductCode());
            int num=productDao.getNum(poItems.get(i).getProductCode());
            pomainDao.insertSr(poItems.get(i).getProductCode(),poId,poItems.get(i).getNum(),stockUser,stockTime);
            productDao.updatePoNum(poNum-poItems.get(i).getNum(),poItems.get(i).getProductCode());
            productDao.updateNum(num+poItems.get(i).getNum(),poItems.get(i).getProductCode());
        }
        pomainDao.in(poId,stockUser,stockTime);
    }

    @Override
    public void outMoney(String poId, String payUser, String payTime) {
        List<Pomain> some = pomainDao.findSome(poId, "", "", "");
        String price=String.valueOf(some.get(0).getPoTotal()-some.get(0).getPrePayFee());
        pomainDao.insertPayC(payTime,price,poId,payUser);
        System.out.println("**********************************"+poId+"***"+payUser+"***"+payTime);
        pomainDao.outMoney(poId,payUser,payTime);
    }

    @Override
    public void outMoney2(String poId, String payUser, String payTime) {
        List<Pomain> some = pomainDao.findSome(poId, "", "", "");
        System.out.println("*************************"+some.get(0));
        String price=String.valueOf(some.get(0).getPrePayFee());
        pomainDao.insertPayC2(payTime,price,poId,payUser);
        pomainDao.outMoney2(poId,payUser,payTime);
    }

    @Override
    public void insertSr(String productCode, String orderCode, int stockNum, String stockUser, String stockTime) {
        pomainDao.insertSr(productCode,orderCode,stockNum,stockUser,stockTime);
    }

    @Override
    public void insertSrC(String productCode, String orderCode, int stockNum, String stockUser, String stockTime) {
        pomainDao.insertSrC(productCode,orderCode,stockNum,stockUser,stockTime);
    }

    @Override
    public void insertPayC(String payTime, String price, String poId, String account) {
        pomainDao.insertPayC(payTime,price,poId,account);
    }

    @Override
    public void insertPayC2(String payTime, String price, String poId, String account) {
        pomainDao.insertPayC2(payTime,price,poId,account);
    }

    @Override
    public int countPomainReportAll(String date) {
        return pomainDao.countPomainReportAll(date);
    }

    @Override
    public int countPomainReportEnd(String date) {
        return pomainDao.countPomainReportEnd(date);
    }

    @Override
    public int totalPomainReport(String date) {
        return pomainDao.totalPomainReport(date);
    }

    @Override
    public int payPomainReport(String date) {
        return pomainDao.payPomainReport(date);
    }

    @Override
    public List<Pomain> findPomainReport(String date) {
        return pomainDao.findPomainReport(date);
    }

    @Override
    public int findInStockReportCount() {
        return pomainDao.findInStockReportCount();
    }

    @Override
    public List<InStock> findInStockReportAll(Map<String, Object> params) {
        return pomainDao.findInStockReportAll(params);
    }

    @Override
    public List<InStock> findInStockReport(String date) {
        return pomainDao.findInStockReport(date);
    }

    @Override
    public int InStockReportCount(String date) {
        return pomainDao.InStockReportCount(date);
    }

    @Override
    public int InStockReportNum(String date) {
        return pomainDao.InStockReportNum(date);
    }

    @Override
    public int InStockReportItemPrice(String date) {
        return pomainDao.InStockReportItemPrice(date);
    }


}
