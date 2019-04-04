package com.xiao.comtroller;

import com.xiao.pojo.User;
import com.xiao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Auther: 笑笑
 * @Date: 15:58 2019/3/30
 */
@RestController
public class ProducerUserController {

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/selectAll")
    @ResponseBody
    public List<User> selectAll(){
        System.out.println(8892);
        return userService.selectAll();
    }
}
