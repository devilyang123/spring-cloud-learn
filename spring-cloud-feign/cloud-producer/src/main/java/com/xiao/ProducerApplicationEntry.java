package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description
 * @Auther: 笑笑
 * @Date: 15:45 2019/3/30
 */
@EnableDiscoveryClient //使用注解开启eureka客户端
@MapperScan("com.xiao.mapper")
@SpringBootApplication
public class ProducerApplicationEntry {

    public static void main(String[] args){
        SpringApplication.run(ProducerApplicationEntry.class, args);
    }

}
