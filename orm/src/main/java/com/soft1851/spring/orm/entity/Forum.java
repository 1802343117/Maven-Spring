package com.soft1851.spring.orm.entity;

import lombok.*;

/**
 * @author xunmi
 * @ClassName Forum
 * @Description TODO
 * @Date 2020/3/17
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class Forum {
    private Integer forumId;
    private String forumName;

}
