package com.personal.restfultodoapp.controller;

import com.personal.restfultodoapp.model.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CrudController {

    @GetMapping(value = "/hello-world")
    public String getCrud() {
        return "Hello World!";
    }

    @GetMapping(value = "/hello-world-with-name/{name}")
    public HelloWorldBean helloWorldWithPath(@PathVariable String name) {
        return HelloWorldBean.builder().message("Hello World!: " + name).build();
    }

    @GetMapping(value = "/hello-world-bean")
    public HelloWorldBean getHelloWorldBean() {
        return HelloWorldBean.builder().message("Hello World Bean!").build();
    }
}
