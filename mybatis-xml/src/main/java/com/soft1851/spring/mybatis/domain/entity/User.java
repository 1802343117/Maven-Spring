package com.soft1851.spring.mybatis.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 12559
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String password;
    private String salt;
    private String email;
    private String phoneNumber;
    private Integer status;
    private Integer binding;
    private Integer credits;
    private LocalDateTime createTime;
    private LocalDateTime lastLoginTime;
}
