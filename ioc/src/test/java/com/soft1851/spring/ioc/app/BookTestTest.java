package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/beans.xml"})
public class BookTestTest {
    @Autowired
    private Book book;
    @Test
    public  void testBook(){
        book.setId(1);
        book.setName("学习java");
        System.out.println(book);
    }
}