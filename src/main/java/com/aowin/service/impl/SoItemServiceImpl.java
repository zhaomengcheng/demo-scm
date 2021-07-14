package com.aowin.service.impl;

import com.aowin.dao.SoItemDao;
import com.aowin.pojo.SoItem;
import com.aowin.service.SoItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("soitemService")
public class SoItemServiceImpl implements SoItemService {
    @Resource
    private SoItemDao soItemDao;
    @Override
    public void insert(SoItem soItem) {
        soItemDao.insert(soItem);
    }

    @Override
    public List<SoItem> getSoItems(String soId) {
        return soItemDao.getSoItems(soId);
    }

    @Override
    public void delete(String soId) {
        soItemDao.delete(soId);
    }
}
