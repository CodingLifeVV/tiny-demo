package com.codinglife.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试接口
 * @author: CodingLifeVV
 * @date: 2022.04.14
 */
@RestController
public class TestController {
    @GetMapping(value = "/hello")
    @SentinelResource
    public String hello() {
        return "hello sentinel!";
    }

    @GetMapping(value = "/hello2")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public String hello2ByResource() {
        return "hello sentinel!";
    }

    public String handleException(BlockException exception){
        return "请求人数太多了！请稍后在试";
    }



}
