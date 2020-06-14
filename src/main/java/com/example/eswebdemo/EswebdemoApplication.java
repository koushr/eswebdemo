package com.example.eswebdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shengruikou
 */
@SpringBootApplication
@MapperScan("com.example.eswebdemo.mapper")
public class EswebdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EswebdemoApplication.class, args);
    }

}
