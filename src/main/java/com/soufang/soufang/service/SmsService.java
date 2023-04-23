package com.soufang.soufang.service;

/**
 * 短信验证码服务
 */
public interface SmsService {
    /**
     * 发送短信验证码
     */
    void sendSms(String phone, String code);
}
