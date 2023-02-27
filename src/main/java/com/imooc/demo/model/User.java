package com.imooc.demo.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull(message = "名字不能为空")
    private String name;

    @Range(min = 1,max = 120,message = "年龄要在1到120之间")
    private int age;

    @Email(message = "Email格式不正确")
    private String email;

    @Past(message = "生日必须为过去的时间")
    private LocalDate birthDay;
}
