package com.aowin.service.impl;

import com.aowin.dao.CheckStockDao;
import com.aowin.dao.PomainDao;
import com.aowin.dao.ProductDao;
import com.aowin.dao.SomainDao;
import com.aowin.pojo.CheckStock;
import com.aowin.pojo.PayRecord;
import com.aowin.service.CheckStockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("checkStockService")
public class CheckStockServiceImpl implements CheckStockService {
    @Resource
    private CheckStockDao checkStockDao;
    @Resource
    private PomainDao pomainDao;
    @Resource
    private SomainDao somainDao;
    @Resource
    private ProductDao productDao;

    @Override
    public void insert(CheckStock checkStock) {
        // insert into stockRecord(productCode,orderCode,stockNum,stockType,stockTime,createUser) values(#{productCode},#{orderCode},#{stockNum},3,#{stockTime},#{stockUser})
        System.out.println("*************************"+checkStock);
        System.out.println("*************************"+checkStock.getType());
        if(checkStock.getType().equals("3")){
        pomainDao.insertSrC(checkStock.getProductCode(),"",checkStock.getRealNum()-checkStock.originNum,checkStock.getCreateUser(),checkStock.getStockTime());
        checkStockDao.insert(checkStock);
        productDao.updateNum(checkStock.getRealNum(),checkStock.getProductCode());
        }
        if(checkStock.getType().equals("4")){
            somainDao.insertSrC(checkStock.getProductCode(),"",checkStock.getRealNum()-checkStock.originNum,checkStock.getCreateUser(),checkStock.getStockTime());
            checkStockDao.insert(checkStock);
            productDao.updateNum(checkStock.getRealNum(),checkStock.getProductCode());
        }
    }

    @Override
    public int countAll() {
        return checkStockDao.countAll();
    }

    @Override
    public List<PayRecord> findAll(Map<String, Object> params) {
        return checkStockDao.findAll(params);
    }

    @Override
    public List<PayRecord> findSome(String orderCode, String start, String end, String pay_type) {
        return checkStockDao.findSome(orderCode,start,end,pay_type);
    }

    @Override
    public float pay1Num(String date) {
        return checkStockDao.pay1Num(date);
    }

    @Override
    public float pay2Num(String date) {
        return checkStockDao.pay2Num(date);
    }

    @Override
    public int pay1Count(String date) {
        return checkStockDao.pay1Count(date);
    }

    @Override
    public int pay2Count(String date) {
        return checkStockDao.pay2Count(date);
    }

    @Override
    public List<PayRecord> stockCheckReportChange(String date) {
        return checkStockDao.stockCheckReportChange(date);
    }
}
