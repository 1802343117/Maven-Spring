package com.soft1851.spring.mybatis.domain.vo;

import lombok.*;

/**
 * @author 12559
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MatterVo {
    private String teacherName;
    private String clazzName;
    private String studentName;
    private String hometown;
    private String birthday;
}
