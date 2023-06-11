package com.soufang.soufang.base;

/**
 * 统一错误码
 */
public enum Status {
    SUCCESS(0, "Success"),
    ERROR_INTERNAL(1, "Internal Error"),
    ERROR_USERNAME_PASSWORD_INVALID(2, "Username Or Password Error"),
    ERROR_FORBIDDEN(3, "Forbidden"),
    ERROR_NOT_LOGIN(4, "NotLogin"),

    ERROR_CITY_NOT_FOUND(1000, "City Not Found"),

    // example 错误码，必须放在最后一行作为示例
    ERROR_EXAMPLE(Integer.MAX_VALUE, "Example");

    private final int code;
    private final String message;

    Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
