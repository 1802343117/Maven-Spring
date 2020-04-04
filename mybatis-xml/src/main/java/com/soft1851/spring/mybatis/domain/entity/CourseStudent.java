package com.soft1851.spring.mybatis.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 12559
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudent {
    private Integer id;
    private Integer courseId;
    private Integer studentId;
}
