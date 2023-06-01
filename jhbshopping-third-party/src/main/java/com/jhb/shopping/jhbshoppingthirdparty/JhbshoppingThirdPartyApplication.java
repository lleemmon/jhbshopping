package com.jhb.shopping.jhbshoppingthirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class JhbshoppingThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JhbshoppingThirdPartyApplication.class, args);
    }

}
