package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-20 11:57
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "commonFallback")
public class OrderHystirxController
{
    @Resource
    PaymentHystrixService service;

    @GetMapping("/provider/ok/{id}")
    public String OkVisit(@PathVariable("id")Integer id)
    {
        return service.paymentInfo_OK(id);
    }

    @GetMapping("/provider/nook/{id}")
    public String lateVisit(@PathVariable("id")Integer id)
    {
        return service.paymentInfo_TimeOut(id);
    }

    public String fallbackMethodMayment(Integer id)
    {
        return "线程池  "+Thread.currentThread().getName()+"对方系统繁忙哦！请稍后再试"+id;
    }

    public String commonFallback()
    {
        return "线程池  "+Thread.currentThread().getName()+"对方系统繁忙哦！死机了！请稍后10秒再试";
    }
}
