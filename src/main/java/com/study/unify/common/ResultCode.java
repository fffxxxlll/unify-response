package com.study.unify.common;

public enum ResultCode {
    /*成功状态码*/
    SUCCESS(1, "成功"),
    PARAM_IS_INVALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return this.code;
    }
    public String getMessage() {
        return this.message;
    }





}
