package com.aowin.controller;

import com.aowin.pojo.Customer;
import com.aowin.response.QueryResult;
import com.aowin.response.Result;
import com.aowin.service.CustomerService;
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
public class CustomerController {
      @Resource
        private CustomerService customerService;
            @GetMapping("customers")
            public QueryResult getAll(Integer currentPage, Integer pageSize, HttpServletRequest request) {
                Page page = new Page(currentPage, pageSize);
                int total = customerService.countAll();
                Map<String, Object> params = new HashMap<>();
                params.put("first", page.getFirst());
                params.put("max", page.getMax());
                List<Customer> list = customerService.findAll(params);
                return QueryResult.ok(total, list);
            }
                @PostMapping("customer")
            public Result save(Customer customer) {
                customerService.insert(customer);
                return Result.ok();
            }

            @PostMapping("customer2")
            public Result update(Customer customer) {
                customerService.update(customer);
                return Result.ok();
            }

                @PostMapping("customer3")
            public Result delete(String customerCode) {
                customerService.delete(customerCode);
                return Result.ok();
            }

                @PostMapping("getCustomer")
            public Result getCustomer(String customerCode) {
                Customer customer = customerService.getCustomer(customerCode);
                return Result.ok(customer);
            }

                @GetMapping("check2")
              public Result check(String customerCode){
                    Customer customer = customerService.getCustomer(customerCode);
                  int i=0;
                  if(customer==null){
                      i=0;
                  }else {
                      i=1;
                  }
                  return Result.ok(i);
              }

    @PostMapping("customername")
    public Result getname() {
       List<Customer> list= customerService.findAll1();
        return Result.ok(list);
    }
}
