package com.xiao.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Auther: 笑笑
 * @Date: 16:06 2019/3/30
 */
@RestController
@DefaultProperties(defaultFallback = "selectAllFallBack") //给所有的接口定义默认的降级处理方法，测试这个可以在服务的提供方 设置睡眠时间来测试
public class ConsumerUserController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/selectAll")
    @ResponseBody
//    @HystrixCommand(fallbackMethod = "selectAllFallBack")   //开启服务降级和线程隔离，配置返回友好信息的方法，默认时间为1秒
    /*@HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")//配置服务降级的超时时长
    })*/
    @HystrixCommand(commandProperties = {   //这些配置也可以在配置文件中添加
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //统计请求次数的阈值
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 熔断器的休眠时间, 10ms
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")  //阈值中请求失败次数的百分比
    })
    public String selectAll(Integer id){
        //测试的时候，传一个偶数的id，多次快速请求之后，熔断器会开启
        //然后立马去发送一个奇数id的请求，可以看到这个正常的请求也会立马返回一个错误，然后稍等一会儿，这个正常的服务又可以使用
        if(id % 2 == 0){
            throw  new RuntimeException("请求异常！");//测试hystrix的熔断，根据穿的参数ID手动控制请求失败的异常
        }
        return restTemplate.getForObject("http://cloud-producer/selectAll", String.class);
    }

    //服务超时， 降级处理返回友好信息的方法
    public String selectAllFallBack(){
       return "服务器正忙，请稍后重试！";
    }

}
