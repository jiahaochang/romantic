package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//1.表示是controller 2.将对象作为http的内容返回
@RestController
public class Hello {
    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello SpringBoot!";
    }
}
