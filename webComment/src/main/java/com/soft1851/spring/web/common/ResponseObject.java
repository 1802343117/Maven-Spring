package com.soft1851.spring.web.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 12559
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
    private  Integer code;
    private  String msg;
    private Object data;
}
