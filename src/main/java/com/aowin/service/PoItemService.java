package com.aowin.service;

import com.aowin.pojo.PoItem;

import java.util.List;

public interface PoItemService {
    void insert(PoItem poItem);
    List<PoItem> getPoItems(String poId);
    void delete(String poId);
}
