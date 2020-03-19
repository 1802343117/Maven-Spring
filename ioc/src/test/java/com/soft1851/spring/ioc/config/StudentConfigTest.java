package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {StudentConfig.class})
public class StudentConfigTest {
    @Autowired
    private Student student;
    @Test
    public void dummy() {
        System.out.println(student);
    }
}