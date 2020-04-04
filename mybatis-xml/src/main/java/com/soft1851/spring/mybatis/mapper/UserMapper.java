package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.domain.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 12559
 */

@Transactional(rollbackFor = Exception.class)
public interface UserMapper {
    /**
     * 新增实体
     * @param user
     */
    void insert(User user);

    /**
     * 根据id删除
     * @param id
     */
    void delete(int id);

    /**
     * 修改
     * @param user
     */
    void update(User user);

    /**
     * 查询所有
     * @return
     */
    List<User> selectAll();

    /**
     * 根据id查询Forum
     * @param id
     * @return Forum
     */
    User selectForumById(int id);
}
