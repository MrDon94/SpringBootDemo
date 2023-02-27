package com.imooc.demo.repository;

import com.imooc.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    public List<User> findByAge(Integer age);
}
