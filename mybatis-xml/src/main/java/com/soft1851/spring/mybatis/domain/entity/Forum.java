package com.soft1851.spring.mybatis.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 12559
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Forum {
    private  Integer forumId;
    private  String forumName;
}
