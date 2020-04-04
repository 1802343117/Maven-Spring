package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Music;

import java.util.List;

/**
 * @author 12559
 */
public interface MusicService {
    /**
     * 查询所有
     * */
    List<Music> queryAll();

    /**
     * 批量插入
     * */
    int[] batchInsert(List<Music> musics);

    /**
     * 截断SQL表
     * */
    void truncate();
}
