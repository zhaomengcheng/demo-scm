package com.aowin.dao;

import com.aowin.pojo.SoItem;

import java.util.List;

public interface SoItemDao {
       void insert(SoItem soItem);
        List<SoItem> getSoItems(String soId);
        void delete(String soId);
}
