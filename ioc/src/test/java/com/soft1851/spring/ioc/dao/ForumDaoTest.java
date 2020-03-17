package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ForumDaoTest {
    @Autowired
    private ForumDao forumDao;

    /**
     * 新增 Forum
     * */
    @Test
    public void insert() {
//        Forum forum = new Forum();
//        forum.setForumName("ABCDE");
//        forumDao.insert(forum);
    }

    /**
     * 批量新增 Forum
     * */
    @Test
    public void batchInsert() {
//        Forum[] forums = {
//                Forum.builder().forumName("测试论坛1").build(),
//                Forum.builder().forumName("测试论坛2").build(),
//                Forum.builder().forumName("测试论坛3").build()
//        };
//        List<Forum> forumList = Arrays.asList(forums);
//        int[] rows = forumDao.batchInsert(forumList);
//        assertEquals(3, rows.length);
    }

    /**
     * 根据id删除Forum
     * */
    @Test
    public void delete() {
//        int n = forumDao.delete(20);
//        assertEquals(1, n);
    }

    /**
     * 修改Forum
     * */
    @Test
    public void update() {
//        Forum forum = forumDao.get(3);
//        forum.setForumName("测试论坛修改的新名称");
//        int n = forumDao.update(forum);
//        assertEquals(1, n);
    }

    /**
     * 根据id查询Forum
     * */
    @Test
    public void get() {
//        Forum forum = forumDao.get(3);
//        assertNotNull(forum);
    }

    /**
     * 查询所有论坛信息
     * */
    @Test
    public void selectAll() {
        List<Forum> forumList = forumDao.selectAll();
        assertEquals(6, forumList.size());
    }
}