package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.domain.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class StudentMapperTest {

    @Resource
    private StudentMapper studentMapper;

    @Test
    public void insert() {
        Student student = Student.builder()
                .clazzId(1)
                .studentName("学生1")
                .hometown("山西晋城")
                .birthday(LocalDate.of(2000, 2, 2))
                .build();
        studentMapper.insert(student);
        System.out.println(student.getStudentId());
    }

    @Test
    public void delete() {
        studentMapper.delete(4009);
    }

    @Test
    public void update() {
        Student student = Student.builder()
                .studentId(2008)
                .clazzId(9)
                .studentName("我被修改了名字")
                .hometown("被修改的城市")
                .birthday(LocalDate.of(1990, 1, 1))
                .build();
        studentMapper.update(student);
    }

    @Test
    public void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = Student.builder()
                    .studentId(4000 + i)
                    .studentName("测试" + i)
                    .clazzId(1)
                    .hometown("测试城市")
                    .birthday(LocalDate.of((int) ((Math.random() * 20) + 1980),
                            (int) (Math.random() * 13),
                            (int) (Math.random() * 29)))
                    .build();
            students.add(student);
        }
        System.out.println(studentMapper.batchInsert(students));
    }

    @Test
    public void batchDelete() {
        Integer[] arr = {4007, 4006, 4005, 4004};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(studentMapper.batchDelete(list));
    }

    @Test
    public void selectLimit() {
        Integer clazzIdKey = 1;
        String hometown = "山西";
        System.out.println(studentMapper.selectLimit(clazzIdKey, hometown));
    }

    @Test
    public void batchUpdate() {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Student student = Student.builder()
                    .studentId(4000 + i)
                    .studentName("测试444" + i)
                    .clazzId(3)
                    .build();
            list.add(student);
        }
        System.out.println(studentMapper.batchUpdate(list));
    }

    @Test
    public void selectLimitByDynamicSql() {
        Student student = Student.builder()
                .clazzId(3)
                .hometown("山西")
                .studentName("张浩杰")
                .build();
        studentMapper.selectLimitByDynamicSql(student).forEach(System.out::println);
    }

    @Test
    public void selectAll() {
        studentMapper.selectAll().forEach(student -> {
            System.out.println(student.getStudentId()
                    + "," + student.getStudentName()
                    + "," + student.getHometown()
                    + "," + student.getBirthday()
                    + "," + student.getClazz().getClazzName());
        });

    }
}