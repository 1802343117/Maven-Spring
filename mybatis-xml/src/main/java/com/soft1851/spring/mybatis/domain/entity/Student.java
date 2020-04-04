package com.soft1851.spring.mybatis.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 12559
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    /**
     * 学生id，主键
     */
    private Integer studentId;
    /**
     * 所属班级id
     */
    private Integer clazzId;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 学生籍贯
     */
    private String hometown;
    /**
     * 学生出生日期
     */
    private LocalDate birthday;
    /**
     * 学生所属班级
     */
    private Clazz clazz;
    /**
     * 所学课程
     */
    private List<Course> courses;
}