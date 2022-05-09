package com.bigking.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bigking.springboot.dao")
public class BIGApplication {

    public static void main(String[] args) {
        SpringApplication.run(BIGApplication.class, args);
    }

}
