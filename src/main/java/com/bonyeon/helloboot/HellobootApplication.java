package com.bonyeon.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class HellobootApplication {
    @Bean
    public HelloController helloController(HelloService helloService) {
        return new HelloController(helloService);
    }

    @Bean
    public HelloService helloService() {
        return new SimpleHelloService();
    }

    public static void main(String[] args) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();
                ServletWebServerFactory webServerFactory = new TomcatServletWebServerFactory();
                WebServer webServer = webServerFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet", // GenericWebApplicationContext를 사용해야 dispatcherServlet사용 가능
                                new DispatcherServlet(this))
                            .addMapping("/*");
                });
                webServer.start();
            }
        };
        applicationContext.register(HellobootApplication.class); // 빈 등록
        applicationContext.refresh(); // 초기화 작업
    }
}
