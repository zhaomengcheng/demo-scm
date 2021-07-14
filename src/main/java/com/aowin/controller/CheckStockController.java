package com.aowin.controller;

import com.aowin.dao.CheckStockDao;
import com.aowin.dao.PomainDao;
import com.aowin.pojo.CheckStock;
import com.aowin.pojo.PayRecord;
import com.aowin.response.QueryResult;
import com.aowin.response.Result;
import com.aowin.service.CheckStockService;
import com.aowin.service.PomainService;
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
public class CheckStockController {
    @Resource
    private CheckStockService checkStockService;


        @PostMapping("updatePNum")
      public Result updateProductNum(CheckStock checkStock) {
         checkStockService.insert(checkStock);
         return Result.ok();
       }
        @GetMapping("payRecords")
                public QueryResult getAll(Integer currentPage, Integer pageSize, HttpServletRequest request) {
                    Page page = new Page(currentPage, pageSize);
                    int total = checkStockService.countAll();
                    Map<String, Object> params = new HashMap<>();
                    params.put("first", page.getFirst());
                    params.put("max", page.getMax());
                    List<PayRecord> list =checkStockService.findAll(params);
                    return QueryResult.ok(total, list);
                }
    @PostMapping("payRecords2")
    public Result getSome(String orderCode,String start,String end,String pay_type) {

        List<PayRecord> list =checkStockService.findSome(orderCode,start,end,pay_type);
        return Result.ok(list);
    }

    @PostMapping("stockCheckReport")
    public Result stockCheckReport(String date) {
        ArrayList list=new ArrayList();
        float a = checkStockService.pay1Num(date);
        float b =checkStockService.pay2Num(date);
        int c=checkStockService.pay1Count(date);
        int d=checkStockService.pay2Count(date);
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        return Result.ok(list);
    }

    @PostMapping("stockCheckReportChange")
    public Result stockCheckReportChange(String date) {
        List<PayRecord> list =checkStockService.stockCheckReportChange(date);
        return Result.ok(list);
    }

}
