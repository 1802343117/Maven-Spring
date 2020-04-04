package com.soft1851.spring.mybatis.domain.vo;

import lombok.*;

import java.time.LocalDate;

/**
 * @author 12559
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClazzVo {
    private Integer clazzId;
    private String clazzName;
    private Integer teacherId;
    private Integer studentId;
    private String studentName;
    private String homeTown;
    private LocalDate birthday;
}