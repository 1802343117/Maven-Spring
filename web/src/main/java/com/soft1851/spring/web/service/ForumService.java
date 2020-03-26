package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Forum;

import java.util.List;

public interface ForumService {
    /**
     * 查询所有的Forum
     * */
    List<Forum> selectAll();
    /**
     * 根据id查询 Forum
     * */
    Forum getForum(int forumid);
}
