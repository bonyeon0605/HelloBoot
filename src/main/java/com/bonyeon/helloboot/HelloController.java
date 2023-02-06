package com.bonyeon.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String hello(String name) {
        return "Hello Spring Boot!" + name;
    }
}
