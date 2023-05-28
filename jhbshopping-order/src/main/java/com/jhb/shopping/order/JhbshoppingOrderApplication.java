package com.jhb.shopping.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.jhb.shopping.order.dao")
@SpringBootApplication
public class JhbshoppingOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JhbshoppingOrderApplication.class, args);
    }

}
