package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    private static final String payMentUrl = "http://cloud-providerconsul-payment";

    @Resource
    RestTemplate restTemplate;


    @GetMapping("/consumer/payment/consul")
    public String paymentzk()
    {
        return restTemplate.getForObject(payMentUrl+"/payment/consul",String.class);
    }
}
