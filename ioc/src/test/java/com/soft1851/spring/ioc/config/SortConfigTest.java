package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Sort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SortConfig.class})
public class SortConfigTest {
    @Autowired
    private Sort sort;
    @Test
    public void dummy() {
        sort.Beansort();
    }
}