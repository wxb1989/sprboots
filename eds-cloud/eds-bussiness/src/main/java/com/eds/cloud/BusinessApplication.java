package com.eds.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
        如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，
        如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。
        */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ServletComponentScan
@EnableScheduling
@EnableAsync
public class BusinessApplication  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BusinessApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }

}
