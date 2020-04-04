
package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.domain.entity.Teacher;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public interface TeacherMapper {
    /**
     * 根据 teacherId 一对一关联查询其管理的班级信息
     * @param teacherId
     * @return Teacher
     */
    Teacher getTeacherOneToOne(int teacherId);

    /**
     * 根据班级 id 查询班级的同时，查找出 Teacher 的信息
     * @param clazzId
     * @return
     */
    Teacher getTeacherByClazzId(int clazzId);
}