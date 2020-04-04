package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.domain.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void update() {
        User user = User.builder()
                .id(1)
                .credits(5)
                .build();
        userMapper.update(user);
    }
}