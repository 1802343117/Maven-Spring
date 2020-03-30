package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.LOL;

import java.util.List;

/**
 * @author 12559
 */
public interface LolService {
    /**
     * 查询所有
     * */
    List<LOL> queryAll();

    /**
     * 单一插入
     * */
    void addLol(LOL lol);

    /**
     * 批量插入
     * */
    int[] batchInsert(List<LOL> lols);
}
