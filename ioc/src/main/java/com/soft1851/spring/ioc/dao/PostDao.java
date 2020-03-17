package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Post;

import java.util.List;

public interface PostDao {
    /**
     * 新增Post
     * @param post 帖子
     * @return int
     */
    int insert(Post post);

    /**
     * 批量新增 Posts
     * @param posts 帖子集合
     * @return int[]
     */
    int[] batchInsert(List<Post> posts);

    /**
     * 根据id删除 Post
     * @param postId id
     * @return int
     */
    int delete(int postId);

    /**
     * 根据id查询 Post
     * @param postId id
     * @return 帖子
     */
    Post get(int postId);

    /**
     * 根据关键字查询 Post
     * @param key 关键字
     * @return list
     */
    List<Post> selectByKey(String key);

    /**
     * 统计某个论坛的帖子总数
     * @param forumId 论坛id
     * @return int
     */
    int count(Integer forumId);
}
