package com.soft1851.spring.ioc.entity;

import lombok.Data;

import java.security.Timestamp;

@Data
public class Post {
    private Integer postId;
    private Integer forumId;
    private String title;
    private String content;
    private String thumbnail;
    private Timestamp createTime;
}
