package com.soft1851.spring.mybatis.domain.dto;

import com.soft1851.spring.mybatis.domain.entity.Student;
import lombok.*;

/**
 * @author 12559
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MatterDto {
    private String teacherName;
    private String clazzName;
    private String studentName;
    private Student student;
}
