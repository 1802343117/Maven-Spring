package com.soft1851.spring.web.service.Impl;

import com.soft1851.spring.web.dao.TopicDao;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 12559
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicDao topicDao;

    @Override
    public List<Topic> queryAll() {
        return topicDao.selectAll();
    }

    @Override
    public void addTopic(Topic topic) {
        topicDao.insert(topic);
        int a = 1 / 0;
    }

    @Override
    public int[] batchInsert(List<Topic> topics) {
        return topicDao.batchInsert(topics);
    }
}
