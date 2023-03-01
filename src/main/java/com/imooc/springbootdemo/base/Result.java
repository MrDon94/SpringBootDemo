package com.imooc.springbootdemo.base;

/**
 * 接口返回值统一结构
 * @param <T>
 */
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public static Result success() {
        return success(null);
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setMessage(MessageEnum.SUCCESS.getMessage());
        result.setCode(MessageEnum.SUCCESS.getCode());
        result.setData(data);
        return result;
    }

    public static Result error(Integer code, String message) {
        Result result = new Result();
        result.setMessage(message);
        result.setCode(code);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
