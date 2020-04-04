package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Music;

import java.util.List;

/**
 * @author 12559
 */

public interface MusicDao {
    /**
     * 查询所有
     * */
    List<Music> selectAll();

    /**
     * 批量插入
     * */
    int[] batchInsert(List<Music> musics);

    /**
     * 截断SQL表
     * */
    void truncate();
}
