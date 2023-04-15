package com.soufang.soufang.api;

import com.soufang.soufang.base.ApiResponse;
import com.soufang.soufang.base.BusinessException;
import com.soufang.soufang.base.Status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 标识此类是一个 controller，controller 用于视图表现
// @RestController // @Controller + @ResponseBody
@RequestMapping("/examples") // 当前类的 URL 路径
public class ExampleController {

    /**
     * hello world 示例，不使用统一响应
     *
     * @return hello world
     */
    @RequestMapping("/hello-world") // 拼接上 controller 的 request mapping ，最终呈现为 url 路径
    @ResponseBody // 直接将返回值作为响应体
    public String helloWorld() {
        return "hello world";
    }

    /**
     * hello world 示例 v2，使用统一响应
     *
     * @return ApiResponse
     */
    @RequestMapping("/v2/hello-world")
    @ResponseBody
    public ApiResponse<String> helloWorldV2() {
        return ApiResponse.success("hello world");
    }

    /**
     * 内部错误响应示例 v2，使用统一响应
     *
     * @return ApiResponse
     */
    @RequestMapping("/v2/errors")
    @ResponseBody
    public ApiResponse<Object> errorsV2() {
        return ApiResponse.error(Status.ERROR_INTERNAL);
    }

    /**
     * 内部错误响应示例 v3, 使用统一响应
     */
    @RequestMapping("/v3/errors")
    @ResponseBody
    public void errorsV3() {
        throw new BusinessException(Status.ERROR_EXAMPLE);
    }

}
