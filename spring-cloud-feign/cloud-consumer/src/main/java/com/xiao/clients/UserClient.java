package com.xiao.clients;

import com.xiao.clients.impl.UserClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cloud-producer", fallback = UserClientFallBack.class) //使用feign的客户端注解，相当于spring的service注解，这样就可以吧远程调用的细节隐藏
//第二个参数是配置熔断返回方法的实现类
public interface UserClient {

    @GetMapping(value = "/selectAll")
    String selectAll(); //如果有参数，写法与controller中的handler的写法一样

}
