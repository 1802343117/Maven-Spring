package com.soft1851.spring.web.service;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.spider.JueJinSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")  //WebAppConfiguration注释类默认为webapp目录，需要切换到src/main/resources目录
public class TopicServiceTest {

    @Autowired
    private TopicService topicService;

    @Test
    public void addTopic() {
        Topic topic = Topic.builder()
                .id("3123")
                .topicName("test")
                .topicIcon("1.png")
                .description("test")
                .msgCount(123)
                .followersCount(123)
                .followed(true)
                .build();
        topicService.addTopic(topic);
    }

    @Test
    public void batchInsert() {
        int[] ints = topicService.batchInsert(JueJinSpider.getTopics());
        assertEquals(JueJinSpider.getTopics().size(), ints.length);
    }

    @Test
    public void queryAll() {
        List<Topic> topics = topicService.queryAll();
        assertEquals(3, topics.size());
    }
}