package com.aowin.dao;

import com.aowin.pojo.PoItem;

import java.util.List;

public interface PoItemDao {
    void insert(PoItem poItem);
    List<PoItem> getPoItems(String poId);
    void delete(String poId);

}
