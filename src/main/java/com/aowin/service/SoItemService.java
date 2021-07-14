package com.aowin.service;

import com.aowin.pojo.SoItem;

import java.util.List;

public interface SoItemService {
    void insert(SoItem soItem);
    List<SoItem> getSoItems(String soId);
    void delete(String soId);
}
