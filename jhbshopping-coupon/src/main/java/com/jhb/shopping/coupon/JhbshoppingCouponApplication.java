package com.jhb.shopping.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.jhb.shopping.coupon.dao")
@SpringBootApplication
public class JhbshoppingCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(JhbshoppingCouponApplication.class, args);
    }

}
