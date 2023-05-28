package com.jhb.shopping.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.jhb.shopping.product.dao")
@SpringBootApplication
public class JhbshoppingProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(JhbshoppingProductApplication.class, args);
    }

}
