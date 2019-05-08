package com.mingjie.life_server.util;

public enum ResultEnum {
    //这里是可以自己定义的，方便与前端交互即可
    SUCCESS(200,"请求成功"),
    REQUEST_ERROR(0,"请求错误"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

