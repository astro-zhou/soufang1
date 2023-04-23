package com.soufang.soufang.api;

import com.soufang.soufang.base.ApiResponse;
import com.soufang.soufang.utils.RedisOperator;
import com.soufang.soufang.utils.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sms")
public class SmsController {

    @Autowired
    private SmsUtils smsUtils;

    @Autowired
    private RedisOperator redis;

    public static final String PHONE_SMSCODE = "phone:smscode";

    @PostMapping("/request_verification")
    public ApiResponse<Object> sendSms(@RequestParam String phone) {
        // 1. 生成随机四位长度的验证码
        String random = (int)((Math.random() * 9 + 1) * 1000) + "";
        // 2. 发送验证码到指定手机号，任选其一
        //              https://cloud.tencent.com/product/sms
        //              https://www.aliyun.com/product/sms
        smsUtils.sendSMS("15838786860", random);
        // 3. 存储验证码（10分钟内有效）
        redis.set(PHONE_SMSCODE + ":" + phone, random, 10 * 60);


        return ApiResponse.success();
    }
}
