package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Topic;

import java.util.List;

/**
 * @author 12559
 */
public interface TopicDao {

    /**
     * 查询所有
     * */
    List<Topic> selectAll();

    /**
     * 批量插入
     */
    int[] batchInsert(List<Topic> topics);

    /**
     * 新增 一个
     */
    int insert(Topic topics);
}
