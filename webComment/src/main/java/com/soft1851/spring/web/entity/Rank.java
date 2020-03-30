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
public class Rank {
    private Integer Id;
    private String heroName;
    private String url;
}
