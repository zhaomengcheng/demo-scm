package com.aowin.service.impl;

import com.aowin.dao.ProductDao;
import com.aowin.dao.SoItemDao;
import com.aowin.dao.SomainDao;
import com.aowin.pojo.OutStock;
import com.aowin.pojo.SoItem;
import com.aowin.pojo.Somain;
import com.aowin.service.SomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("somainservice")
public class SomainServiceImpl implements SomainService {
    @Resource
    private SomainDao somainDao;
        @Resource
        private SoItemDao soItemDao;
        @Resource
        private ProductDao productDao;

    @Override
    public int countAll() {
        return somainDao.countAll();
    }

    @Override
    public int countAll2() {
        return somainDao.countAll2();
    }

    @Override
    public int countEnd1() {
        return somainDao.countEnd1();
    }

    @Override
    public int countEnd2() {
        return somainDao.countEnd2();
    }

    @Override
    public int countEnd3() {
        return somainDao.countEnd3();
    }

    @Override
    public int countOut1() {
        return somainDao.countOut1();
    }

    @Override
    public int countOut2() {
        return somainDao.countOut2();
    }

    @Override
    public int countOut3() {
        return somainDao.countOut3();
    }

    @Override
    public int countInMoney1() {
        return somainDao.countInMoney1();
    }

    @Override
    public int countInMoney2() {
        return somainDao.countInMoney2();
    }

    @Override
    public int countInMoney3() {
        return somainDao.countInMoney3();
    }

    @Override
    public List<Somain> findAll2(Map<String, Object> params) {
        return somainDao.findAll2(params);
    }

    @Override
    public List<Somain> findAll(Map<String, Object> params) {
        return somainDao.findAll(params);
    }

    @Override
    public List<Somain> findEnd1(Map<String, Object> params) {
        return somainDao.findEnd1(params);
    }

    @Override
    public List<Somain> findEnd2(Map<String, Object> params) {
        return somainDao.findEnd2(params);
    }

    @Override
    public List<Somain> findEnd3(Map<String, Object> params) {
        return somainDao.findEnd3(params);
    }

    @Override
    public List<Somain> findOut1(Map<String, Object> params) {
        return somainDao.findOut1(params);
    }

    @Override
    public List<Somain> findOut2(Map<String, Object> params) {
        return somainDao.findOut2(params);
    }

    @Override
    public List<Somain> findOut3(Map<String, Object> params) {
        return somainDao.findOut3(params);
    }

    @Override
    public List<Somain> findInMoney1(Map<String, Object> params) {
        return somainDao.findInMoney1(params);
    }

    @Override
    public List<Somain> findInMoney2(Map<String, Object> params) {
        return somainDao.findInMoney2(params);
    }

    @Override
    public List<Somain> findInMoney3(Map<String, Object> params) {
        return somainDao.findInMoney3(params);
    }

    @Override
    public List<Somain> findSome(String soId, String status, String start, String end) {
        return somainDao.findSome(soId,status,start,end);
    }

    @Override
    public void insert(Somain somain) {
        List<SoItem> soItems = somain.getSoItems();
                for (int i = 0; i < soItems.size(); i++) {
                    int soNum = productDao.getSoNum(soItems.get(i).getProductCode());
                    productDao.updateSoNum(soNum+soItems.get(i).getNum(),soItems.get(i).getProductCode());
                }
                somainDao.insert(somain);
                for (int i = 0; i < soItems.size(); i++) {
                    soItemDao.insert(soItems.get(i));
                }
    }

    @Override
    public Somain getSomain(String soId) {
        return somainDao.getSomain(soId);
    }

    @Override
    public Somain getSomain2(String soId) {
        return somainDao.getSomain2(soId);
    }

    @Override
    public void delete(String soId) {
        List<SoItem> soItems=soItemDao.getSoItems(soId);
                for (int i = 0; i < soItems.size(); i++) {
                    int soNum=productDao.getSoNum(soItems.get(i).getProductCode());
                    productDao.updateSoNum(soNum-soItems.get(i).getNum(),soItems.get(i).getProductCode());
                }
               soItemDao.delete(soId);
               somainDao.delete(soId);

    }

    @Override
    public void end(String soId, String endUser, String endTime) {
        somainDao.end(soId,endUser,endTime);
    }

    @Override
    public void out(String soId, String stockUser, String stockTime) {
       List<SoItem> soItems=soItemDao.getSoItems(soId);
        for (int i = 0; i < soItems.size(); i++) {
            int soNum=productDao.getSoNum(soItems.get(i).getProductCode());
            int num=productDao.getNum(soItems.get(i).getProductCode());
            somainDao.insertSr(soItems.get(i).getProductCode(),soId,soItems.get(i).getNum(),stockUser,stockTime);
            productDao.updateSoNum(soNum-soItems.get(i).getNum(),soItems.get(i).getProductCode());
            productDao.updateNum(num-soItems.get(i).getNum(),soItems.get(i).getProductCode());
        }
        somainDao.out(soId,stockUser,stockTime);
    }

    @Override
    public void inMoney(String soId, String payUser, String payTime) {
        List<Somain> some = somainDao.findSome(soId, "", "", "");
        String price=String.valueOf(some.get(0).getSoTotal()-some.get(0).getPrePayFee());
        somainDao.insertPayC(payTime,price,soId,payUser);
        somainDao.inMoney(soId,payUser,payTime);
    }

    @Override
    public void inMoney2(String soId, String payUser, String payTime) {
        List<Somain> some = somainDao.findSome(soId, "", "", "");
        System.out.println("*************************"+some.get(0));
        String price=String.valueOf(some.get(0).getPrePayFee());
        somainDao.insertPayC2(payTime,price,soId,payUser);
        somainDao.inMoney2(soId,payUser,payTime);
    }

    @Override
    public void insertSr(String productCode, String orderCode, int stockNum, String stockUser, String stockTime) {
        somainDao.insertSr(productCode,orderCode,stockNum,stockUser,stockTime);
    }

    @Override
    public void insertSrC(String productCode, String orderCode, int stockNum, String stockUser, String stockTime) {
        somainDao.insertSrC(productCode,orderCode,stockNum,stockUser,stockTime);
    }

    @Override
    public void insertPayC(String payTime, String price, String soId, String account) {
        somainDao.insertPayC(payTime,price,soId,account);
    }

    @Override
    public void insertPayC2(String payTime, String price, String soId, String account) {
        somainDao.insertPayC2(payTime,price,soId,account);
    }

    @Override
    public int countSomainReportAll(String date) {
        return somainDao.countSomainReportAll(date);
    }

    @Override
    public int countSomainReportEnd(String date) {
        return somainDao.countSomainReportEnd(date);
    }

    @Override
    public int totalSomainReport(String date) {
        return somainDao.totalSomainReport(date);
    }

    @Override
    public int paySomainReport(String date) {
        return somainDao.paySomainReport(date);
    }

    @Override
    public List<Somain> findSomainReport(String date) {
        return somainDao.findSomainReport(date);
    }

    @Override
    public int findOutStockReportCount() {
        return somainDao.findOutStockReportCount();
    }

    @Override
    public List<OutStock> findOutStockReportAll(Map<String, Object> params) {
        return somainDao.findOutStockReportAll(params);
    }

    @Override
    public List<OutStock> findOutStockReport(String date) {
        return somainDao.findOutStockReport(date);
    }

    @Override
    public int OutStockReportCount(String date) {
        return somainDao.OutStockReportCount(date);
    }

    @Override
    public int OutStockReportNum(String date) {
        return somainDao.OutStockReportNum(date);
    }

    @Override
    public int OutStockReportItemPrice(String date) {
        return somainDao.OutStockReportItemPrice(date);
    }
}
