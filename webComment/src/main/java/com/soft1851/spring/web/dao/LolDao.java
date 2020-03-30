package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.LOL;

import java.util.List;

/**
 * @author 12559
 */
public interface LolDao {

    /**
     * 查询所有
     * */
    List<LOL> selectAll();

    /**
     * 批量插入
     * */
    int[] batchInsert(List<LOL> lols);

    /**
     * 单个插入
     * */
    int insert(LOL lol);
}
