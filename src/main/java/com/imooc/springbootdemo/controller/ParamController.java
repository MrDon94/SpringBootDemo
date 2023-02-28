package com.imooc.springbootdemo.controller;

import com.imooc.springbootdemo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api
@RestController
public class ParamController {

    @ApiOperation(value = "无注解方式")
    @GetMapping("/noannotation")
    public User noAnnotation(User user){
        return user;
    }

    @ApiOperation(value = "@requestParams方式")
    @GetMapping("/requestparam")
    public User RequestParam(@RequestParam String name,@RequestParam int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @ApiOperation(value = "@PathVariable方式")
    @GetMapping("/pathvariable/{name}/{age}")
    public User PathVariable(@PathVariable String name,@PathVariable int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @ApiOperation(value = "@RequestBody方式")
    @PostMapping("/requestboy")
    public User RequestBody(@Valid @RequestBody User user){
        return user;
    }
}
