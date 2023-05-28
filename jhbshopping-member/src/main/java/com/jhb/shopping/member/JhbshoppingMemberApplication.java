package com.jhb.shopping.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.jhb.shopping.member.feign")
@EnableDiscoveryClient
@MapperScan("com.jhb.shopping.member.dao")
@SpringBootApplication
public class JhbshoppingMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(JhbshoppingMemberApplication.class, args);
    }

}
