package com.aowin.dao;

import com.aowin.pojo.Product;
import com.aowin.pojo.StockRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductDao {
    int countAll();
    List<Product> findAll(Map<String, Object> params);
    List<Product> findProduct(@Param("productCode")String productCode,@Param("name")String name,@Param("min")String min,@Param("max")String max);
    void insert (Product product);
    void delete(String productCode);
    Product getProduct(String productCode);
    void update(Product product);
    Product getAll();
    int getNum(String productCode);
    int getPoNum(String productCode);
    int getSoNum(String productCode);
    void updateNum(@Param("num") int Num, @Param("productCode") String productCode);
    void updatePoNum(@Param("poNum") int poNum, @Param("productCode") String productCode);
    void updateSoNum(@Param("soNum") int soNum,@Param("productCode") String productCode);
    int getSumNum();
    int getIn(@Param("date")String date,@Param("now")String now);
    int getOut(@Param("date")String date,@Param("now")String now);
    List<Product> stockReportList(@Param("date")String date,@Param("now")String now);
    List<StockRecord> findStockRecord(String productCode);
}
