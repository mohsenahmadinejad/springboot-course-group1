package com.example.demo;


import org.springframework.stereotype.Component;

@Component
public class HelloBean {
    public String sayHello(){
        return "Hello world";
    }
}
