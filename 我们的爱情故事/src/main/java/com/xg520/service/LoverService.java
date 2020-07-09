package com.xg520.service;

import com.xg520.dao.LoverDao;
import com.xg520.domain.Lover;

public interface LoverService {
    /**
     * 登录
     * @param lover 恋人
     * @return 返回恋人，若为null，登录出错
     */
    public Lover login(Lover lover);
}
