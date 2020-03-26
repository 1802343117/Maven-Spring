package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ForumServiceTest {

    @Autowired
    private ForumService forumService;

    @Test
    public void selectAll() {
        System.out.println("查询全部信息");
        List<Forum> forums = forumService.selectAll();
        System.out.println(forums);
        System.out.println("查询ID为：5 的信息");
        Forum forum = forumService.getForum(5);
        System.out.println(forum);
    }
}