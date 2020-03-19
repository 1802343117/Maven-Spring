package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {

    private static Logger logger = LoggerFactory.getLogger(TestStudent.class);

    public static void main(String[] args) {
        logger.info("开始测试");
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) ac.getBean("student");
        logger.info(student.toString());
    }

}
