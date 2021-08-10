package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class OrderController {

    private static final String payMentUrl = "http://cloud-provider-zkPayment";

    @Resource
    RestTemplate restTemplate;


    @GetMapping("/consumer/payment/zk")
    public String paymentzk()
    {
        return restTemplate.getForObject(payMentUrl+"/payment/zk",String.class);
    }
}
