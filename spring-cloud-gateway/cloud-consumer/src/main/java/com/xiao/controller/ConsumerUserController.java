package com.xiao.controller;


import com.xiao.clients.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description
 * @Auther: 笑笑
 * @Date: 16:06 2019/3/30
 */
@RestController
public class ConsumerUserController {

    @Autowired
    private UserClient userClient;


    @GetMapping(value = "/selectAll")
    @ResponseBody
    public String selectAll(){
        return userClient.selectAll(); //直接调用方法
    }

}
