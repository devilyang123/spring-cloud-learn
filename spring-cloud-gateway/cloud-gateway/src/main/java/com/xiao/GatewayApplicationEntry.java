package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description
 * @Auther: 笑笑
 * @Date: 17:37 2019/4/5
 */
@EnableZuulProxy //开启zuul代理
@SpringBootApplication
public class GatewayApplicationEntry {

    public static void main(String[] args){
        SpringApplication.run(GatewayApplicationEntry.class, args);
    }

}
