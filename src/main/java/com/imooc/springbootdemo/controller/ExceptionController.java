package com.imooc.springbootdemo.controller;

import com.imooc.springbootdemo.base.ApiException;
import com.imooc.springbootdemo.base.MessageEnum;
import com.imooc.springbootdemo.base.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("/apiException")
    public Result apiException(){
        throw new ApiException(MessageEnum.ERROR);
    }

    @GetMapping("/runtimeException")
    public Result runtimeException(){
        throw new RuntimeException();
    }
}
