package com.imooc.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api
@Slf4j
@RestController
public class HelloController {

    @ApiOperation("Hello Spring Boot 方法")
    @GetMapping("/")
    public String hello(@RequestParam(required = false) @ApiParam("名字") String name){
        if (name == null || "".equals(name)){
            return "Spring Boot";
        }
        log.info("hello");
        return "Hello " + name;
    }
}
