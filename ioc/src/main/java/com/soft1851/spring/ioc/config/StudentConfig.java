package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
@ComponentScan("com.soft1851.spring.ioc")
public class StudentConfig {
    @Bean
    public Student student() {
        Student student = new Student();
        //使用SET方法
        student.setId(007);
        student.setName("Tom");
        //添加复杂类型 Set
        Set<String> set = new HashSet();
        set.add("吃");
        set.add("喝");
        set.add("玩");
        student.setSet(set);
        //复杂类型的添加 List
        List<String> list = new ArrayList();
        list.add("打游戏");
        list.add("运动");
        list.add("编程");
        student.setHobbies(list);
        //添加复杂类型 Map
        Map<String,String> map = new HashMap();
        map.put("HTML","网页的结构");
        map.put("CSS","网页的样式");
        map.put("JavaScript","网页的行为");
        student.setMap(map);
        return student;
    }
}
