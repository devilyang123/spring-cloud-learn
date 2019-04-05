package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description
 * @Auther: 笑笑
 * @Date: 17:30 2019/3/30
 */
@EnableEurekaServer //使用注解启用EurekaServer
@SpringBootApplication
public class EurekaServerEntry {

    public static void main(String[] args){
        SpringApplication.run(EurekaServerEntry.class, args);
    }
}
