package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Rank;

import java.util.List;

/**
 * @author 12559
 */
public interface RankService {
    /**
     * 查询所有
     * */
    List<Rank> queryAll();

    /**
     * 单一插入
     * */
    void addLol(Rank rank);

    /**
     * 批量插入
     * */
    int[] batchInsert(List<Rank> ranks);
}
