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
public class Clazz {
    /**
     * 班级id，主键
     */
    private Integer clazzId;
    /**
     * 班级名称
     */
    private String clazzName;
    /**
     * 班级管理老师的id
     */
    private Integer teacherId;
    /**
     * 管理班级的老师
     */
    private Teacher teacher;
    /**
     * 班级学生集合
     */
    private List<Student> students;
}
