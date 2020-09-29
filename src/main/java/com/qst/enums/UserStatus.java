package com.qst.enums;

/**
 * @Author: XiPeng
 * @Description:
 * @Date: Create in 19:18 2020/9/29
 * @Modified by:
 */
public enum UserStatus {
    REGISTER_SUCCESS(1000,"成功"),
    REGISTER_FAIL(1001,"失败");


    private int code;
    private String message;
    private Object data;

    UserStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    UserStatus(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
