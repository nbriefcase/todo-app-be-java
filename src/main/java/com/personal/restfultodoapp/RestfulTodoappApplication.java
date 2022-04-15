package com.personal.restfultodoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class RestfulTodoappApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestfulTodoappApplication.class, args);
    }
}
