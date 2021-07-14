package com.aowin.controller;

import com.aowin.pojo.InStock;
import com.aowin.pojo.Pomain;
import com.aowin.response.QueryResult;
import com.aowin.response.Result;
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
public class PomainController {
    @Resource
    private PomainService pomainService;

         @GetMapping("pomains")
                public QueryResult getAll(Integer currentPage, Integer pageSize, HttpServletRequest request) {
                    Page page = new Page(currentPage, pageSize);
                    int total = pomainService.countAll();
                    Map<String, Object> params = new HashMap<>();
                    params.put("first", page.getFirst());
                    params.put("max", page.getMax());
                    List<Pomain> list = pomainService.findAll(params);
                     System.out.println("==========================="+list+"===========");
                    return QueryResult.ok(total, list);
                }

    @GetMapping("pomainss")
    public QueryResult getAll2(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = pomainService.countAll2();
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Pomain> list = pomainService.findAll2(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }

    @GetMapping("pomainsEnd1")
    public QueryResult getEnd1(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = pomainService.countEnd1();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Pomain> list = pomainService.findEnd1(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @GetMapping("pomainsEnd2")
    public QueryResult getEnd2(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = pomainService.countEnd2();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Pomain> list = pomainService.findEnd2(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @GetMapping("pomainsEnd3")
    public QueryResult getEnd3(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = pomainService.countEnd3();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Pomain> list = pomainService.findEnd3(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @GetMapping("pomainsIn1")
    public QueryResult getIn1(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = pomainService.countIn1();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Pomain> list = pomainService.findIn1(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @GetMapping("pomainsIn2")
    public QueryResult getIn2(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = pomainService.countIn2();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Pomain> list = pomainService.findIn2(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @GetMapping("pomainsIn3")
    public QueryResult getIn3(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = pomainService.countIn3();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Pomain> list = pomainService.findIn3(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }

 @GetMapping("pomainsOutMoney1")
    public QueryResult pomainsOutMoney1(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = pomainService.countOutMoney1();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Pomain> list = pomainService.findOutMoney1(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @GetMapping("pomainsOutMoney2")
    public QueryResult pomainsOutMoney2(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = pomainService.countOutMoney2();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Pomain> list = pomainService.findOutMoney2(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @GetMapping("pomainsOutMoney3")
    public QueryResult pomainsOutMoney3(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = pomainService.countOutMoney3();
        if (total==0){
            total=1;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<Pomain> list = pomainService.findOutMoney3(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @PostMapping("pomains2")
     public Result getSome(String poId,String status,String start,String end){
        System.out.println("*****************************************************"+status);
        List<Pomain> list =   pomainService.findSome(poId,status,start,end);
        return Result.ok(list);
    }
    @PostMapping("pomains3")
    public Result delete(String poId){
       pomainService.delete(poId);
        return Result.ok();
    }

    @PostMapping("account")
    public Result account(HttpServletRequest request){
          Object account=request.getAttribute("account");
        return Result.ok(account);
    }
    @PostMapping("addPoMain")
    public Result addPomain(Pomain poMain){
        System.out.println("**************************************************"+poMain);
        pomainService.insert(poMain);
        return Result.ok();
    }


    @PostMapping("getPomain")
    public Result getPomain(String poId){
        Pomain pomain = pomainService.getPomain(poId);
        return Result.ok(pomain);
    }
    @PostMapping("getPomain2")
    public Result getPomain2(String poId){
        Pomain pomain = pomainService.getPomain2(poId);
        return Result.ok(pomain);
    }
    @PostMapping("endPomain")
    public Result endPomain(String poId,String endUser,String endTime){
       pomainService.end(poId,endUser,endTime);
        return Result.ok();
    }
    @PostMapping("inPomain")
    public Result inPomain(String poId,String stockUser,String stockTime){
        pomainService.in(poId,stockUser,stockTime);
        return Result.ok();
    }
        @PostMapping("outMoneyPomain")
        public Result outMoneyPomain(String poId,String payUser,String payTime){
            pomainService.outMoney(poId,payUser,payTime);
            return Result.ok();
        }

        @PostMapping("outMoneyPomain2")
        public Result outMoneyPomain2(String poId,String payUser,String payTime){
            pomainService.outMoney2(poId,payUser,payTime);
            return Result.ok();
        }

    @PostMapping("pomainReport")
    public Result pomainReport(String date){
        int count1=pomainService.countPomainReportAll(date);
        int count2=pomainService.countPomainReportEnd(date);
        int price1=pomainService.totalPomainReport(date);
        int price2=pomainService.payPomainReport(date);
        ArrayList arrayList=new ArrayList();
        arrayList.add(count1);
        arrayList.add(count2);
        arrayList.add(price1);
        arrayList.add(price2);
        return Result.ok(arrayList);
    }

    @PostMapping("pomainReportList")
    public Result pomainReportList(String date) {
        List<Pomain> list=pomainService.findPomainReport(date);
        return Result.ok(list);
    }

    @GetMapping("inStocks")
    public QueryResult findInStockAll(Integer currentPage, Integer pageSize, HttpServletRequest request) {
        Page page = new Page(currentPage, pageSize);
        int total = pomainService.findInStockReportCount();
        Map<String, Object> params = new HashMap<>();
        params.put("first", page.getFirst());
        params.put("max", page.getMax());
        List<InStock> list = pomainService.findInStockReportAll(params);
        System.out.println("==========================="+list+"===========");
        return QueryResult.ok(total, list);
    }
    @PostMapping("inStockReport")
    public Result inStockReport(String date){
        int count1=pomainService.InStockReportCount(date);
        int count2=pomainService.InStockReportNum(date);
        int count3=pomainService.InStockReportItemPrice(date);
        ArrayList arrayList=new ArrayList();
        arrayList.add(count1);
        arrayList.add(count2);
        arrayList.add(count3);
        return Result.ok(arrayList);
    }
    @PostMapping("inStockReportList")
    public Result inStockReportList(String date) {
        List<InStock> list=pomainService.findInStockReport(date);
        return Result.ok(list);
    }
}
