package com.aowin.service;

import com.aowin.pojo.Vender;

import java.util.List;
import java.util.Map;

public interface VenderService {
    int countAll();
    List<Vender> findAll(Map<String, Object> params);
    void insert (Vender vender);
    void delete(String venderCode);
    Vender getVender(String venderCode);
    void update(Vender vender);
    List<Vender> findAll1();
}
