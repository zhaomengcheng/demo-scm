package com.aowin.controller;

import com.aowin.pojo.OutStock;
import com.aowin.pojo.Somain;
import com.aowin.response.QueryResult;
import com.aowin.response.Result;
import com.aowin.service.SomainService;
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
public class SomainController {
    @Resource
    private SomainService somainService;
       @GetMapping("somains")
                public QueryResult getAll(Integer currentPage, Integer pageSize, HttpServletRequest request) {
                    Page page = new Page(currentPage, pageSize);
                    int total = somainService.countAll();
                    Map<String, Object> params = new HashMap<>();
                    params.put("first", page.getFirst());
                    params.put("max", page.getMax());
                    List<Somain> list = somainService.findAll(params);
                     System.out.println("==========================="+list+"===========");
                    return QueryResult.ok(total, list);
                }

    @GetMapping("somainss")
    public QueryResult getAll2(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = somainService.countAll2();
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Somain> list = somainService.findAll2(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }

    @GetMapping("somainsEnd1")
    public QueryResult getEnd1(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = somainService.countEnd1();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Somain> list = somainService.findEnd1(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @GetMapping("somainsEnd2")
    public QueryResult getEnd2(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = somainService.countEnd2();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Somain> list = somainService.findEnd2(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @GetMapping("somainsEnd3")
    public QueryResult getEnd3(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = somainService.countEnd3();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Somain> list = somainService.findEnd3(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @GetMapping("somainsOut1")
    public QueryResult getOut1(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = somainService.countOut1();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Somain> list = somainService.findOut1(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @GetMapping("somainsOut2")
    public QueryResult getOut2(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = somainService.countOut2();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Somain> list = somainService.findOut2(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @GetMapping("somainsOut3")
    public QueryResult getOut3(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = somainService.countOut3();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Somain> list = somainService.findOut3(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @GetMapping("somainsInMoney1")
    public QueryResult getInMoney1(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = somainService.countInMoney1();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Somain> list = somainService.findInMoney1(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @GetMapping("somainsInMoney2")
    public QueryResult getInMoney2(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = somainService.countInMoney2();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Somain> list = somainService.findInMoney2(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @GetMapping("somainsInMoney3")
    public QueryResult getInMoney3(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = somainService.countInMoney3();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Somain> list = somainService.findInMoney3(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }



    @PostMapping("somains2")
     public Result getSome(String soId,String status,String start,String end){
        System.out.println("*****************************************************"+status);
        List<Somain> list =   somainService.findSome(soId,status,start,end);
        return Result.ok(list);
    }
    @PostMapping("somains3")
    public Result delete(String soId){
       somainService.delete(soId);
        return Result.ok();
    }


    @PostMapping("addSoMain")
    public Result addSomain(Somain soMain){
        System.out.println("**************************************************"+soMain);
        somainService.insert(soMain);
        return Result.ok();
    }


    @PostMapping("getSomain")
    public Result getSomain(String soId){
        Somain somain = somainService.getSomain(soId);
        return Result.ok(somain);
    }
    @PostMapping("getSomain2")
    public Result getSomain2(String soId){
        Somain somain = somainService.getSomain2(soId);
        return Result.ok(somain);
    }
    @PostMapping("endSomain")
    public Result endSomain(String soId,String endUser,String endTime){
       somainService.end(soId,endUser,endTime);
        return Result.ok();
    }
    @PostMapping("outSomain")
    public Result outSomain(String soId,String stockUser,String stockTime){
        somainService.out(soId,stockUser,stockTime);
        return Result.ok();
    }
    @PostMapping("inMoneySomain")
    public Result inMoneySomain(String soId,String payUser,String payTime){
        somainService.inMoney(soId,payUser,payTime);
        return Result.ok();
    }

    @PostMapping("inMoneySomain2")
    public Result inMoneySomain2(String soId,String payUser,String payTime){
        somainService.inMoney2(soId,payUser,payTime);
        return Result.ok();
    }


        @PostMapping("somainReport")
        public Result somainReport(String date){
            int count1=somainService.countSomainReportAll(date);
            int count2=somainService.countSomainReportEnd(date);
            int price1=somainService.totalSomainReport(date);
            int price2=somainService.paySomainReport(date);
            ArrayList arrayList=new ArrayList();
            arrayList.add(count1);
            arrayList.add(count2);
            arrayList.add(price1);
            arrayList.add(price2);
            return Result.ok(arrayList);
        }

        @PostMapping("somainReportList")
        public Result somainReportList(String date) {
            List<Somain> list=somainService.findSomainReport(date);
            return Result.ok(list);
        }
           @GetMapping("outStocks")
        public QueryResult findOutStockAll(Integer currentPage, Integer pageSize, HttpServletRequest request) {
            Page page = new Page(currentPage, pageSize);
            int total = somainService.findOutStockReportCount();
            Map<String, Object> params = new HashMap<>();
            params.put("first", page.getFirst());
            params.put("max", page.getMax());
            List<OutStock> list = somainService.findOutStockReportAll(params);
            System.out.println("==========================="+list+"===========");
            return QueryResult.ok(total, list);
        }
        @PostMapping("outStockReport")
        public Result outStockReport(String date){
            int count1=somainService.OutStockReportCount(date);
            int count2=somainService.OutStockReportNum(date);
            int count3=somainService.OutStockReportItemPrice(date);
            ArrayList arrayList=new ArrayList();
            arrayList.add(count1);
            arrayList.add(count2);
            arrayList.add(count3);
            return Result.ok(arrayList);
        }
        @PostMapping("outStockReportList")
        public Result outStockReportList(String date) {
            List<OutStock> list=somainService.findOutStockReport(date);
            return Result.ok(list);
        }
}
