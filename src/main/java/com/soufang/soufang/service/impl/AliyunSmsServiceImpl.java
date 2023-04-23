package com.soufang.soufang.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.soufang.soufang.base.AliyunResource;
import com.soufang.soufang.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * 基于阿里云服务实现的短信验证码服务
 */
@Service
@ConditionalOnProperty(prefix = "app.sms", name = "provider", havingValue = "aliyun")
public class AliyunSmsServiceImpl implements SmsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AliyunSmsServiceImpl.class);

    public final AliyunResource aliyunResource;

    public AliyunSmsServiceImpl(AliyunResource aliyunResource) {
        this.aliyunResource = aliyunResource;
    }

    @Override
    public void sendSms(String phone, String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                aliyunResource.getAccessKeyID(),
                aliyunResource.getAccessSecret());
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");

        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "宇航学习");
        request.putQueryParameter("TemplateCode", "SMS_273495129");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");

        try {
            CommonResponse response = client.getCommonResponse(request);
            LOGGER.debug(response.getData());
        } catch (ClientException e) {
            throw new RuntimeException("发送验证码失败, phone: " + phone, e);
        }
    }
}
