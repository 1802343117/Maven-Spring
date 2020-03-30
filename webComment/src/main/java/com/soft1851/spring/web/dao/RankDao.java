package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Rank;

import java.util.List;

/**
 * @author 12559
 */
public interface RankDao {
    /**
     * 查询所有
     * */
    List<Rank> selectAll();

    /**
     * 批量插入
     * */
    int[] batchInsert(List<Rank> ranks);

    /**
     * 单个插入
     * */
    int insert(Rank rank);
}
