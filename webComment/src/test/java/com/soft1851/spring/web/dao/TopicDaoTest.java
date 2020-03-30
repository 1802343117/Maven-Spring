//package com.soft1851.spring.web.dao;
//
//import com.soft1851.spring.web.config.SpringDataSourceConfig;
//import com.soft1851.spring.web.entity.Topic;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.TransactionStatus;
//
//import java.util.Arrays;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {SpringDataSourceConfig.class})
//@WebAppConfiguration("src/main/resources")  //WebAppConfiguration注释类默认为webapp目录，需要切换到src/main/resources目录
//public class TopicDaoTest {
//
//    @Autowired
//    private TopicDao topicDao;
//    @Autowired
//    private DataSourceTransactionManager dataSourceTransactionManager;
//
//    @Test
//    public void selectAll() {
//        assertEquals(2, topicDao.selectAll().size());
//    }
//
//    @Test
//    public void insert() {
//        TransactionStatus status = null;
//        Topic topics[] = {
//                new Topic("测试数据", "1.jpg", 111, 111),
//                new Topic("测试数据1", "2.jpg", 222, 222),
//                new Topic("测试数据2", "3.jpg", 333, 333)
//        };
//        int ints[] = topicDao.batchInsert(Arrays.asList(topics));
//        assertEquals(3, ints.length);
//    }
//
//    @Test
//    public void batchInsert() {}
//
//    /**
//     * 开启事务
//     * */
//    public TransactionStatus begin() {
//        return beginTransaction(dataSourceTransactionManager)
//    }
//
//    /**
//     * 提交事务
//     * */
//    public void commit(TransactionStatus status) {
//        commitTransaction(dataSourceTransactionManager, status);
//    }
//
//    /*
//     * 回滚事务
//     * */
//    public void rollback(TransactionStatus status) {
//        rollbackTransaction(dataSourceTransactionManager, status);
//    }
//}