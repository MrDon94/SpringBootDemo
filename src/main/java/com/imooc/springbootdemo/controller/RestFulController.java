package com.imooc.springbootdemo.controller;

import com.imooc.springbootdemo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/rest")
public class RestFulController {

    @ApiOperation(value = "根据id获取用户信息")
    @GetMapping("/user/{id}")
    public User get(@PathVariable int id){
        User user = new User();
        user.setId(id);
        user.setName("ID为"+id+"的用户");
        user.setAge(28);
        user.setEmail("123@163.com");
        return user;
    }

    @ApiOperation(value = "创建用户")
    @PostMapping("/create")
    public boolean create(@RequestBody User user){
        if (user != null){
            return true;
        }
        return false;
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("/update")
    public boolean update(@RequestBody User user){
        if (user != null){
            return true;
        }
        return false;
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id){
        if (id > 0){
            return true;
        }
        return false;
    }
}
