package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Auther: 笑笑
 * @Date: 16:04 2019/3/30
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplicationEntry {

    public static void main(String[] args){
        SpringApplication.run(ConsumerApplicationEntry.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
