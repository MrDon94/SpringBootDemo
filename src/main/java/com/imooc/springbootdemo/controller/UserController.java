package com.imooc.springbootdemo.controller;

import com.imooc.springbootdemo.mapper.UserMapper;
import com.imooc.springbootdemo.model.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public User get(@PathVariable int id){
        return userMapper.selectByPrimaryKey(id);
    }

    @PostMapping
    public int create(@RequestBody User user){
        return userMapper.insert(user);
    }

    @PutMapping
    public int update(@RequestBody User user){
        return userMapper.updateByPrimaryKey(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        userMapper.deleteByPrimaryKey(id);
    }

}
