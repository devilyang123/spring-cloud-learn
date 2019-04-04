package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced//eureka默认已经引入了ribbon的依赖，只需要在这里开启负载均衡就可以，默认是轮询的策略
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
