package com.aowin.controller;

import com.aowin.pojo.Product;
import com.aowin.pojo.StockRecord;
import com.aowin.response.QueryResult;
import com.aowin.response.Result;
import com.aowin.service.ProductService;
import com.aowin.utils.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Resource
    private ProductService productService;
         @GetMapping("products")
            public QueryResult getAll(Integer currentPage, Integer pageSize, HttpServletRequest request) {

                Page page = new Page(currentPage, pageSize);
                int total = productService.countAll();
                Map<String, Object> params = new HashMap<>();
                params.put("first", page.getFirst());
                params.put("max", page.getMax());
                List<Product> list = productService.findAll(params);
             System.out.println("***************************"+list);
                return QueryResult.ok(total, list);
            }
    @PostMapping("products2")
     public Result getProduct(String productCode,String name,String min,String max){
        List<Product> list =   productService.findProduct(productCode,name,min,max);
        return Result.ok(list);
    }
    @PostMapping("product")
    public Result save(Product product) {
        productService.insert(product);
        return Result.ok();
    }
    @PostMapping("product2")
    public Result updata(Product product) {
        productService.update(product);
        return Result.ok();
    }


    @PostMapping("product3")
    public Result delete(String productCode) {
        productService.delete(productCode);
        return Result.ok();
    }

      @PostMapping("getProduct")
        public Result getProduct(String productCode) {
            Product product = productService.getProduct(productCode);
          System.out.println("*******************************"+product);
            return Result.ok(product);
        }
    @PostMapping("getAll")
    public Result getAll() {
        Product product = productService.getAll();
        return Result.ok(product);
    }
      @GetMapping("check")
      public Result check(String productCode){
          Product product = productService.getProduct(productCode);
          int i=0;
          if(product==null){
              i=0;
          }else {
              i=1;
          }
          return Result.ok(i);
      }

    @PostMapping("updateProductNum")
    public Result updateProductNum(String num,String productCode) {
        System.out.println("*****************************"+num);
        System.out.println("*****************************"+productCode);
        productService.updateNum(Integer.parseInt(num), productCode);
        return Result.ok();
    }
     @PostMapping("stockReport")
        public Result stockReport(){
         int a=productService.getSumNum();
         System.out.println("***************************========="+a);
            return Result.ok(a);
        }

    @PostMapping("stockReport2")
    public Result stockReport2(String date,String now){
        int a=productService.getSumNum();
        int b=a-productService.getIn(date,now)+productService.getOut(date,now);
        int c=productService.getIn(date,now)-productService.getOut(date,now);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaa"+productService.getIn(date,now)+"bbbbbbbbbb"+productService.getOut(date,now));
        ArrayList arrayList=new ArrayList();
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(c);
        return Result.ok(arrayList);
    }
    @PostMapping("stockReportChange")
    public Result stockReportChange(String date,String now){
        List<Product> products = productService.stockReportList(date, now);
        System.out.println("================================"+products);
        return Result.ok(products);
    }
    @PostMapping("findStockRecord")
    public Result findStockRecord(String productCode){
        List<StockRecord> stockRecord = productService.findStockRecord(productCode);
        return Result.ok(stockRecord);
    }
}
