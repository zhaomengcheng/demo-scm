package com.aowin.service;

import com.aowin.pojo.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    int countAll();
    List<Customer> findAll(Map<String, Object> params);
    void insert (Customer customer);
    void delete(String customerCode);
    Customer getCustomer(String customerCode);
    void update(Customer customer);
    List<Customer> findAll1();
}
