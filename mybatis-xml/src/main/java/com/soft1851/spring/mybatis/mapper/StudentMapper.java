package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.domain.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public interface StudentMapper {

    /**
     * 新增Student，并返回自增主键
     *
     * @param student
     */
    void insert(Student student);

    /**
     * 根据 studentID 删除 Student
     *
     * @param studentId
     */
    void delete(int studentId);

    /**
     * 更新 Student
     *
     * @param student
     */
    void update(Student student);

    /**
     * 批量插入
     *
     * @param students
     * @return int
     */
    int batchInsert(@Param("students") List<Student> students);

    /**
     * 批量删除
     *
     * @param idList
     * @return int
     */
    int batchDelete(@Param("idList") List<Integer> idList);

    /**
     * 批量修改
     *
     * @param student
     * @return int
     */
    int batchUpdate(@Param("students") List<Student> student);

    /**
     * 单表（带两个指定条件）查询
     *
     * @param clazzId
     * @param hometownKey
     * @return List<Student>
     */
    List<Student> selectLimit(@Param("clazzId") Integer clazzId, @Param("hometownKey") String hometownKey);

    /**
     * 单表指定条件查询（结合动态 SQL ）
     *
     * @param student
     * @return
     */
    List<Student> selectLimitByDynamicSql(Student student);

    /**
     * 查询所有学生，按生日排序，多对一关联查询学生所在班级信息
     *
     * @return List<Student>
     */
    List<Student> selectAll();
}