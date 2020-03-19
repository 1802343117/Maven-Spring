package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Sort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.soft1851.spring.ioc")
public class SortConfig {
    @Bean
    public Sort sort() {
        return new Sort();
    }
}
