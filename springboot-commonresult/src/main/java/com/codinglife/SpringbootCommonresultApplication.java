package com.codinglife;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.codinglife.mapper")
public class SpringbootCommonresultApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCommonresultApplication.class, args);
    }

}
