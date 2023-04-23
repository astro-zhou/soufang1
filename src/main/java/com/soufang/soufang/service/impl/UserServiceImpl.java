package com.soufang.soufang.service.impl;

import com.soufang.soufang.base.BusinessException;
import com.soufang.soufang.base.Status;
import com.soufang.soufang.service.SmsService;
import com.soufang.soufang.service.UserService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    private static final String PHONE_SMSCODE = "phone:smscode";

    private final SmsService smsService;
    private final StringRedisTemplate template;

    public UserServiceImpl(SmsService smsService, StringRedisTemplate template) {
        this.smsService = smsService;
        this.template = template;
    }

    @Override
    public void requestVerification(String phone) {
        String code = generateCode();
        smsService.sendSms(phone, code);
        template.opsForValue().set(PHONE_SMSCODE + ":" + phone, code, 10, TimeUnit.MINUTES);
    }

    @Override
    public boolean validateVerification(String phone, String code) {
        if (!StringUtils.hasText(phone) || !StringUtils.hasText(code)) {
            throw new BusinessException(Status.ERROR_USERNAME_PASSWORD_INVALID);
        }
        String c = template.opsForValue().get(PHONE_SMSCODE + ":" + phone);
        return code.equals(c);
    }

    private String generateCode() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 1000));
    }
}
