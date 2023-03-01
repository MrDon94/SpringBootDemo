package com.imooc.springbootdemo.base;

/**
 * 错误消息封装
 */
public enum MessageEnum {
    UNKNOW_ERROR(-1, "未知错误！"),
    ERROR(500, "系统错误"),
    SUCCESS(0, "操作成功！"),
    ;
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    MessageEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
