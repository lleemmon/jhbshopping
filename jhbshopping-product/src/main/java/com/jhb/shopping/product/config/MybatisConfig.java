package com.jhb.shopping.product.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement//允许事务功能
@MapperScan("com.jhb.shopping.product.dao")
public class MybatisConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //大于最大页后回到主页
        paginationInterceptor.setOverflow(true);
        //最大但也限制数量 默认500 -1不受限制
        paginationInterceptor.setLimit(1000);
        return paginationInterceptor;
    }
}
