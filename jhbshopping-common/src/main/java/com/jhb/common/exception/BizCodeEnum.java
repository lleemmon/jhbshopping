package com.jhb.common.exception;

import lombok.Getter;

@Getter
public enum BizCodeEnum {
    UNKNOWN_EXCEPTION(10000, "系统未知异常"),
    VALID_EXCEPTION(10001, "参数格式校验失败")
    ;

    private Integer code;
    private String message;
    BizCodeEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
