package com.bonyeon.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@RequestMapping
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    @ResponseBody // 해당 어노테이션이 없으면 스프링은 view 경로를 찾기 때문에 404 발생
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
