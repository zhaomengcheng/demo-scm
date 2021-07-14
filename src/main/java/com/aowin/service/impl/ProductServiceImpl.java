package com.aowin.service.impl;

import com.aowin.dao.ProductDao;
import com.aowin.pojo.Product;
import com.aowin.pojo.StockRecord;
import com.aowin.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("productService")
public class ProductServiceImpl implements com.aowin.service.ProductService{
    @Resource
    private ProductDao productDao;
    @Override
    public int countAll() {
        return productDao.countAll();
    }

    @Override
    public List<Product> findAll(Map<String, Object> params) {
        return productDao.findAll(params);
    }

    @Override
    public List<Product> findProduct(String productCode, String name, String min, String max) {
        return productDao.findProduct(productCode,name,min,max);
    }

    @Override
    public void insert(Product product) {
        productDao.insert(product);
    }

    @Override
    public void delete(String productCode) {
        productDao.delete(productCode);
    }

    @Override
    public Product getProduct(String productCode) {
       return productDao.getProduct(productCode);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public Product getAll() {
        return productDao.getAll();
    }

    @Override
    public int getNum(String productCode) {
        return productDao.getNum(productCode);
    }

    @Override
    public int getPoNum(String productCode) {
        return productDao.getPoNum(productCode);
    }

    @Override
    public int getSoNum(String productCode) {
        return productDao.getSoNum(productCode);
    }

    @Override
    public void updateNum(int num, String productCode) {
        productDao.updateNum(num,productCode);
    }

    @Override
    public void updatePoNum(int poNum, String productCode) {
        productDao.updatePoNum(poNum,productCode);
    }

    @Override
    public void updateSoNum(int soNum, String productCode) {
        productDao.updateSoNum(soNum,productCode);
    }

    @Override
    public int getSumNum() {
        return productDao.getSumNum();
    }

    @Override
    public int getIn(String date, String now) {
        return productDao.getIn(date,now);
    }

    @Override
    public int getOut(String date, String now) {
        return productDao.getOut(date,now);
    }

    @Override
    public List<Product> stockReportList(String date, String now) {
        return productDao.stockReportList(date,now);
    }

    @Override
    public List<StockRecord> findStockRecord(String productCode) {
        return productDao.findStockRecord(productCode);
    }


}
