package com.aowin.service.impl;

import com.aowin.dao.VenderDao;
import com.aowin.pojo.Vender;
import com.aowin.service.VenderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service("venderService")
public class VenderServiceImpl implements VenderService {
    @Resource
    private VenderDao venderDao;
    @Override
    public int countAll() {
        return venderDao.countAll();
    }

    @Override
    public List<Vender> findAll(Map<String, Object> params) {
        return venderDao.findAll(params);
    }

    @Override
    public void insert(Vender vender) {
        venderDao.insert(vender);
    }

    @Override
    public void delete(String venderCode) {
        venderDao.delete(venderCode);
    }

    @Override
    public Vender getVender(String venderCode) {
        return venderDao.getVender(venderCode);
    }

    @Override
    public void update(Vender vender) {
        venderDao.update(vender);
    }

    @Override
    public List<Vender> findAll1() {
        return venderDao.findAll1();
    }
}
