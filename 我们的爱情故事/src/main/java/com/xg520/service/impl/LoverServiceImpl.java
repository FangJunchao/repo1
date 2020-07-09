package com.xg520.service.impl;

import com.xg520.dao.LoverDao;
import com.xg520.domain.Lover;
import com.xg520.service.LoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loverService")
public class LoverServiceImpl implements LoverService {

    @Autowired
    private LoverDao loverDao;

    @Override
    public Lover login(Lover lover) {
        //1. 判断username是否存在
        if (loverDao.findLoverByUsername(lover.getUsername())==null)    {
            Lover loverError = new Lover();
            loverError.setId(3);
            return loverError;
        }else {
            Lover loginLover = loverDao.findLoverByUsernameAndPassword(lover);
            if (loginLover ==null)   {
                Lover loverError = new Lover();
                loverError.setId(4);
                return loverError;
            }else {
                return loginLover;
            }
        }
    }
}
