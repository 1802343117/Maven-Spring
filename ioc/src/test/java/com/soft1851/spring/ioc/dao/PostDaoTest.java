package com.soft1851.spring.ioc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PostDaoTest {

    @Autowired
    private PostDao postDao;

    /**
     * 添加帖子
     * */
    @Test
    public void insert() {
//        Post post = Post.builder().forumId(1).content("测试1").build();
//        int n = postDao.insert(post);
//        assertEquals(1, n);
//        System.out.println(n);
    }

    /**
     * 批量添加帖子
     * */
    @Test
    public void batchInsert() {
//        Post[] posts = {
//                Post.builder().forumId(3).content("测试1").build(),
//                Post.builder().forumId(3).content("测试2").build(),
//                Post.builder().forumId(3).content("测试3").build(),
//                Post.builder().forumId(3).content("测试4").build(),
//                Post.builder().forumId(3).content("测试5").build(),
//                Post.builder().forumId(3).content("测试6").build(),
//        };
//        List<Post> postList = Arrays.asList(posts);
//        int[] rows = postDao.batchInsert(postList);
//        assertEquals(6, rows.length);
    }

    /**
     * 根据id删除 Post
     * */
    @Test
    public void delete() {
//        int n = postDao.delete(30);
//        assertEquals(1, n);
    }

    /**
     * 根据id查询 Post
     * */
    @Test
    public void selectByWords() {
//        List<Post> postList = postDao.selectByKey("2");
//        postList.forEach(item -> System.out.println(item.getPostId()));
    }

    /**
     * 根据关键字查询 Post
     * */
    @Test
    public void count() {
        int i = 1;
        System.out.println(postDao.count(i));
    }
}