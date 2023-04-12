package com.bonyeon.helloboot;

import com.bonyeon.config.MySpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MySpringBootApplication
public class HellobootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class ,args);
    }

}
