package com.imooc.springbootdemo.base;

public class ApiException extends RuntimeException{
    private Integer code;

    public ApiException(MessageEnum messageEnum) {
        super(messageEnum.getMessage());
        this.code = messageEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
