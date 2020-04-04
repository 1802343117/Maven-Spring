package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 12559
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Music {
    private Integer id;
    private String title;
    private String url;
    private String singer;
    private String cover;
}
