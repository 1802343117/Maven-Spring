package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 12559
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    /**
     * 课程id
     */
    private Integer courseId;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 课程学生列表
     */
    private List<Student> students;
}
