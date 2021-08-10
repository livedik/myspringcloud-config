package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    private static final String payMentUrl = "http://CLOUD-PAMENT-SERVICE";

    @Resource
    RestTemplate restTemplate;


    @GetMapping(value = "/consumer/payment/add")
    public CommonResult add(Payment payment)
    {
        return restTemplate.postForObject(payMentUrl+"/payment/add",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(payMentUrl+"/payment/get/"+id,CommonResult.class);
    }
}
