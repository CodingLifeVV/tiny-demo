package com.codinglife.api;

/**
 * @author CodingLife
 * @Description TODD
 * @since 2022/3/6 17:24
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingLife
 * @Description 自定义异常
 * @since 2022/3/6 17:01
 */

@Data
@AllArgsConstructor  //有参数构造器
@NoArgsConstructor   //生成无参数构造
public class CustomizeApiException extends RuntimeException {
    private Integer code;   // 状态码
    private String msg;     // 输出消息
}
