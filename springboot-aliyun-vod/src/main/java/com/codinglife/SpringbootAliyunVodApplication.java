package com.codinglife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootAliyunVodApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootAliyunVodApplication.class, args);
    }
}
