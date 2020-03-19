package com.soft1851.spring.orm.entity;

import com.alibaba.druid.sql.visitor.functions.Char;
import lombok.*;

import java.security.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    private Integer postId;
    private Integer forumId;
    private String title;
    private String content;
    private Char[] thumbnail;
    private Timestamp postTime;

}