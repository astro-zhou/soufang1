package com.soufang.soufang.api;

import com.soufang.soufang.base.ApiResponse;
import com.soufang.soufang.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sms")
public class SmsController {

    private final UserService userService;

    public SmsController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/request_verification")
    public ApiResponse<Object> sendSms(@RequestParam String phone) {
        userService.requestVerification(phone);
        return ApiResponse.success();
    }
}
