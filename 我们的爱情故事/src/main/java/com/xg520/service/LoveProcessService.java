package com.xg520.service;

import com.xg520.domain.LoveProcess;

import java.util.List;

public interface LoveProcessService {
    /**
     * 发表
     * @param loveProcess 历程帖
     */
    public void publish(LoveProcess loveProcess);

    /**
     *修改
     * @param loveProcess 修改内容
     */
    public void modify(LoveProcess loveProcess);

    /**
     * 删除
     * @param id 主键
     */
    public void delete(Integer id);

    /**
     * 查询所有
     * @return 结果的列表
     */
    public List<LoveProcess> findAll();
}
