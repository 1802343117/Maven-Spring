package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Post;

import java.util.List;

/**
 * @author wl
 * @ClassNamePostDao
 * @Description TODO
 * @Date 2020/3/17
 * @Version 1.0
 */
public interface PostDao {
    /**
     * 插入数据
     * @param post
     * @return
     */
    int insert(Post post);

    /**
     * 批量插入数据
     * @param posts
     * @return
     */
    int[] bathInsert(List<Post>posts);

    /**
     * 根据id删除post
     * @param postId
     * @return
     */
    int delete(int postId);

    /**
     * 批量删除
     * @param posts
     * @return
     */
    int[] batchDelete(List<Post>posts);

    /**
     * 统计
     * @return
     */
    int count();
    /**
     * 修改post
     * @param post
     * @return
     */
    int update(Post post);

    /**
     * 根据id查询post
     *
     * @param postId
     * @return
     */
    Post get(int postId);

    /**
     * 查询所有帖子
     * @return
     */
    List<Post>selectAll();

    /**
     * 模糊
     * @param key
     * @return
     */
    List<Post> selectByKey( String key);
}
