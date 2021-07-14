package com.aowin.service.impl;

import com.aowin.dao.CustomerDao;
import com.aowin.pojo.Customer;
import com.aowin.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;
    @Override
    public int countAll() {
        return customerDao.countAll();
    }

    @Override
    public List<Customer> findAll(Map<String, Object> params) {
        return customerDao.findAll(params);
    }

    @Override
    public void insert(Customer customer) {
        customerDao.insert(customer);
    }

    @Override
    public void delete(String customerCode) {
        customerDao.delete(customerCode);
    }

    @Override
    public Customer getCustomer(String customerCode) {
        return customerDao.getCustomer(customerCode);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public List<Customer> findAll1() {
        return customerDao.findAll1();
    }
}
