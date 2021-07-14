package com.aowin.service.impl;

import com.aowin.dao.PoItemDao;
import com.aowin.pojo.PoItem;
import com.aowin.service.PoItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("poitemService")
public class PoItemServiceImpl implements PoItemService {
    @Resource
    private PoItemDao poItemDao;
    @Override
    public void insert(PoItem poItem) {
        poItemDao.insert(poItem);
    }

    @Override
    public List<PoItem> getPoItems(String poId) {
        return poItemDao.getPoItems(poId);
    }

    @Override
    public void delete(String poId) {
        poItemDao.delete(poId);
    }
}
