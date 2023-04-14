package com.soufang.soufang.base;

/**
 * Web 层统一的 API 响应封装
 * <p>
 * eg:
 * <code>
 * {
 * "code": 0,
 * "message": "SUCCESS",
 * "data": null
 * }
 * </code>
 */
public class ApiResponse<T> {

    /**
     * 工厂方法，创建成功响应
     *
     * @param data 响应数据
     * @param <T>  响应数据类型
     * @return 统一 API 响应封装
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(Status.SUCCESS, data);
    }

    /**
     * 工厂方法，创建成功响应
     *
     * @return 统一 API 响应封装
     */
    public static ApiResponse<Object> success() {
        return new ApiResponse<>(Status.SUCCESS);
    }

    /**
     * 工厂方法
     *
     * @param status 统一响应码枚举
     * @return 统一 API 响应封装
     */
    public static ApiResponse<Object> error(Status status) {
        return new ApiResponse<>(status);
    }

    /**
     * 响应码，代表的是响应的状态
     */
    private int code;
    /**
     * 响应码的可读描述信息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(Status status, T data) {
        this.code = status.getCode();
        this.message = status.getMessage();
        this.data = data;
    }

    public ApiResponse(Status status) {
        this(status, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
