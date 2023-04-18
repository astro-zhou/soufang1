package com.soufang.soufang.api;

import com.soufang.soufang.base.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sms")
public class SmsController {

    @PostMapping("/request_verification")
    public ApiResponse<Object> sendSms(@RequestParam String phone) {
        // 1. 生成随机四位长度的验证码
        // 2. 发送验证码到指定手机号，任选其一
        //              https://cloud.tencent.com/product/sms
        //              https://www.aliyun.com/product/sms
        // 3. 存储验证码（10分钟内有效）
        return ApiResponse.success();
    }
}
