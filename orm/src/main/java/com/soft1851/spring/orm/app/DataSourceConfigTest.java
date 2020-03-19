package com.soft1851.spring.orm.app;

import com.soft1851.spring.orm.config.DataSourceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DataSourceConfigTest {
    public static void main(String[] args) {
        //生成基于注解配置的应用上下文对象
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        //手动启动扫包
        acac.scan("com.soft1851.spring.ioc.config");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) acac.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);

//        ForumDao forumDao = (ForumDao) acac.getBean("forumDao");
//        List<Forum> forums = forumDao.selectAll();
//        System.out.println(forums);
    }
}
