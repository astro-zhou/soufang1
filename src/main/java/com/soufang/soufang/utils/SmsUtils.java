package com.soufang.soufang.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: yuhang
 * @Date: 2023/4/23 17:18
 * @Version: 1.0
 **/
@Component
public class SmsUtils {

    @Autowired
    public AliyunResource aliyunResource;

    public void sendSMS(String mobile, String code) {
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

        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "宇航学习");
        request.putQueryParameter("TemplateCode", "SMS_273495129");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code +"\"}");

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
