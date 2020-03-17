package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.config.AppConfig;
import com.soft1851.spring.ioc.entity.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookTest {
    public static void main(String[] args) {
        //生成基于注解配置的应用上下文对象
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
        //手动启动扫包
        acac.scan("com.soft1851.spring.ioc.config");
        Book book=(Book)acac.getBean("book");
        book.setId(1);
        book.setName("学习java");
        System.out.println(book);
    }
}