package com.jhb.shopping.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.jhb.shopping.ware.dao")
@SpringBootApplication
public class JhbshoppingWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(JhbshoppingWareApplication.class, args);
    }

}
