package com.soufang.soufang.service.impl;

import com.soufang.soufang.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(prefix = "app.sms", name = "provider", havingValue = "none", matchIfMissing = true)
public class NoopSmsServiceImpl implements SmsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NoopSmsServiceImpl.class);

    @Override
    public void sendSms(String phone, String code) {
        LOGGER.info("[仅开发模式使用]手机号：{}，发送验证码： {}", phone, code);
    }
}
