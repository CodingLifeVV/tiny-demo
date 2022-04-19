package com.codinglife.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author CodingLife
 * @Description TODD
 * @since 2022/3/20 20:08
 */
@Data
@TableName("user")
public class User {

    // id 是自增的,因此不需要使用@ExcelProperty注解
    private Long id;
    @ExcelProperty(index = 1)
    private String name;
    @ExcelProperty(index = 2)
    private Integer age;
    @ExcelProperty(index = 3)
    private String email;
}
