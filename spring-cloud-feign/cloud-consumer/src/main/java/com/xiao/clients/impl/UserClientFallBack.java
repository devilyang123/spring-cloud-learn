package com.xiao.clients.impl;

import com.xiao.clients.UserClient;
import org.springframework.stereotype.Component;

//feign的熔断返回方法
@Component
public class UserClientFallBack implements UserClient {

    @Override
    public String selectAll() {
        return "服务器超时，请稍后重试！"; //测试熔断方法 可以直接把服务的提供方关闭
    }
}
