package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Topic;

import java.util.List;

/**
 * @author 12559
 */
public interface TopicService {
    /**
    * 查询所有的Topic
    * */
    List<Topic> queryAll();

    /**
    * 单一插入
    * */
    void addTopic(Topic topic);

    /**
    * 批量插入
    * */
    int[] batchInsert(List<Topic> topics);
}
