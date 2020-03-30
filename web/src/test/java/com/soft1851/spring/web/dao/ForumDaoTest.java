package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
@WebAppConfiguration("src/main/resources")  //WebAppConfiguration注释类默认为webapp目录，需要切换到src/main/resources目录
public class ForumDaoTest {

    @Autowired
    private ForumDao forumDao;

    @Test

    public void selectAll() {
        List<Forum> forums = forumDao.selectAll();
        System.out.println(forums);
    }
}