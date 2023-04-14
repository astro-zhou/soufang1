package com.soufang.soufang.base;

/**
 * 业务异常，表明是由业务处理主动抛出的错误，这是无法被后端修复的错误，需要前端/用户手动处理
 */
public class BusinessException extends RuntimeException {
    private final int code;

    public BusinessException(String message) {
        super(message);
        this.code = Status.ERROR_INTERNAL.getCode();
    }

    public BusinessException(String message, Throwable t) {
        super(message, t);
        this.code = Status.ERROR_INTERNAL.getCode();
    }

    public BusinessException(Throwable t) {
        super(Status.ERROR_INTERNAL.getMessage(), t);
        this.code = Status.ERROR_INTERNAL.getCode();
    }

    public BusinessException(Status status) {
        super(status.getMessage());
        this.code = status.getCode();
    }

    public BusinessException(Status status, Throwable t) {
        super(status.getMessage(), t);
        this.code = status.getCode();
    }

    public int getCode() {
        return code;
    }
}
