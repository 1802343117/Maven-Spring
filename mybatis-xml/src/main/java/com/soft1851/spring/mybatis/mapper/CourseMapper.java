
package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.domain.entity.Course;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public interface CourseMapper {
    /**
     * 根据班课 id 查询班课详情（班课自身信息、学生列表）
     * @param courseId
     * @return Course
     */
    Course getCourseById(int courseId);
}