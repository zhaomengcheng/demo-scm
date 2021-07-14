package com.aowin.controller;

import com.aowin.pojo.Vender;
import com.aowin.response.QueryResult;
import com.aowin.response.Result;
import com.aowin.service.VenderService;
import com.aowin.utils.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VenderController {
    @Resource
    private VenderService venderService;
        @GetMapping("venders")
        public QueryResult getAll(Integer currentPage, Integer pageSize, HttpServletRequest request) {
            Page page = new Page(currentPage, pageSize);
            int total = venderService.countAll();
            Map<String, Object> params = new HashMap<>();
            params.put("first", page.getFirst());
            params.put("max", page.getMax());
            List<Vender> list = venderService.findAll(params);
            return QueryResult.ok(total, list);
        }
            @PostMapping("vender")
        public Result save(Vender vender) {
            venderService.insert(vender);
            return Result.ok();
        }

        @PostMapping("vender2")
        public Result update(Vender vender) {
            venderService.update(vender);
            return Result.ok();
        }

            @PostMapping("vender3")
        public Result delete(String venderCode) {
            venderService.delete(venderCode);
            return Result.ok();
        }

            @PostMapping("getVender")
        public Result getVender(String venderCode) {
            Vender vender = venderService.getVender(venderCode);
            return Result.ok(vender);
        }

            @GetMapping("check1")
          public Result check(String venderCode){
                Vender vender = venderService.getVender(venderCode);
              int i=0;
              if(vender==null){
                  i=0;
              }else {
                  i=1;
              }
              return Result.ok(i);
          }
            @PostMapping("vendername")
        public Result getname() {
           List<Vender> list= venderService.findAll1();
            return Result.ok(list);
        }
}
