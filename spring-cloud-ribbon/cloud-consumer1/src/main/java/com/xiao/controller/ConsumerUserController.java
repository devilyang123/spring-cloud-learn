package com.xiao.controller;


import com.xiao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Auther: 笑笑
 * @Date: 16:06 2019/3/30
 */
@RestController
public class ConsumerUserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/selectAll")
    @ResponseBody
    public List<User> selectAll(){
        User[] userArray = restTemplate.getForObject("http://cloud-producer/selectAll", User[].class);
        if(userArray != null){
            return Arrays.asList(userArray);
        }
        return null;
    }

/*
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/selectAll")
    @ResponseBody
    public List<User> selectAll(){
        //根据服务ID获取实例， 可能为多个
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PRODUCER");
        //通过实例获取ID 和端口(自己测试，确定为一个)
        String host = instances.get(0).getHost();
        int port = instances.get(0).getPort();
        User[] userArray = restTemplate.getForObject("http://" + host + ":" + port + "/selectAll", User[].class);
        if(userArray != null){
          return Arrays.asList(userArray);
        }
        return null;
    }*/


}
