package com.mby.enter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author meiby
 * @version 1.0
 * @description
 * @date 2018/11/1 10:52
 */
@Configuration
@ComponentScan("com.mby")
@MapperScan("com.mby.dao")
@ImportResource("classpath:spring-context.xml")
@SpringBootApplication
public class Starter extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Starter.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}
