package com.mby.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ex_meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 10:52
 */
@Configuration
@ComponentScan("com.mby")
@MapperScan("com.mby.dao")
@SpringBootApplication
public class Starter {

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}
