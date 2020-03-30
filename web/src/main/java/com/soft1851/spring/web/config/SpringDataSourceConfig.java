package com.soft1851.spring.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@ComponentScan("com.soft1851.spring.web")
public class SpringDataSourceConfig {
    /**
     * 数据库连接池设置
     * */
    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.driverClassName");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        // 配置初始化大小、最小、最大
        druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxActive(20);
        // 配置获取连接等待超时的时间
        druidDataSource.setMaxWait(60000);
        // 配置一个连接在池中最小生存的时间，单位是毫秒
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        // 禁止自动提交，实现事务管理
        druidDataSource.setDefaultAutoCommit(false);
        // 设置连接池启动预处理事务集
        druidDataSource.setPoolPreparedStatements(true);
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(druidDataSource());
    }

    /**
     * 装配事务管理器
     *
     * */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DruidDataSource druidDataSource) {
        return new DataSourceTransactionManager(druidDataSource);
    }
}

