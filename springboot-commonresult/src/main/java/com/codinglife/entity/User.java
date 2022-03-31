package com.codinglife.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    @NotBlank(message = "名字不为空")
    private String name;
    @NotNull(message = "年龄不为空")
    private Integer age;
    @Email(message = "邮箱格式不正确")
    private String email;
}
