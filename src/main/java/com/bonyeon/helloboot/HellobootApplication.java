package com.bonyeon.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class HellobootApplication {

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
