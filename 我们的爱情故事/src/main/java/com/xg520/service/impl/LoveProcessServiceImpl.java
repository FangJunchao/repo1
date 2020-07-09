package com.xg520.service.impl;

import com.xg520.dao.LoveProcessDao;
import com.xg520.domain.LoveProcess;
import com.xg520.service.LoveProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loverProcessService")
public class LoveProcessServiceImpl implements LoveProcessService {
    @Autowired
    private LoveProcessDao loveProcessDao;

    @Override
    public void publish(LoveProcess loveProcess) {
        loveProcessDao.insert(loveProcess);
    }

    @Override
    public void modify(LoveProcess loveProcess) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<LoveProcess> findAll() {
        return loveProcessDao.selectAll();
    }
}
