package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.entity.Sort;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SortTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");
        Sort sort = (Sort) ac.getBean("sort");
        sort.Beansort();
    }
}
