package com.soufang.soufang.base;

import com.soufang.soufang.entity.User;
import com.soufang.soufang.repository.RoleRepository;
import com.soufang.soufang.repository.UserRepository;
import com.soufang.soufang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 手机号验证码登陆过滤器
 * <p>
 * POST /api/sessions?method=sms
 * <p>
 * phone=13100000000&code=1234
 */
@Component
public class SmsCodeFilter extends AbstractAuthenticationProcessingFilter {

    private static final RequestMatcher DEFAULT_REQUEST_MATCHER = new RequestMatcher() {
        private final AntPathRequestMatcher inner = new AntPathRequestMatcher("/api/sessions", "POST");

        @Override
        public boolean matches(HttpServletRequest request) {
            return inner.matches(request) && checkParameter(request);
        }

        private boolean checkParameter(HttpServletRequest request) {
            return "sms".equals(request.getParameter("method"));
        }
    };

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserService userService;

    public SmsCodeFilter(UserRepository userRepository, RoleRepository roleRepository, UserService userService) {
        super(DEFAULT_REQUEST_MATCHER);
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @Override
    public void afterPropertiesSet() {
        // 重写此方法，主要是为了覆盖父类校验 authenticationManager,因为子类父类都没有用
    }

    @Autowired
    @Override
    public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler successHandler) {
        super.setAuthenticationSuccessHandler(successHandler);
    }

    @Autowired
    @Override
    public void setAuthenticationFailureHandler(AuthenticationFailureHandler failureHandler) {
        super.setAuthenticationFailureHandler(failureHandler);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String phone = request.getParameter("phone");
        phone = (phone != null) ? phone.trim() : "";
        String code = request.getParameter("code");
        code = (code != null) ? code : "";

        // 4. 验证码验证
        if (!userService.validateVerification(phone, code)) {
            throw new BadCredentialsException(this.messages
                    .getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }

        String finalPhone = phone;
        User user = userRepository.findByPhoneNumber(phone).orElseGet(() -> {
            // 如果没找到用户则自动注册
            User u = new User();
            u.setId(System.currentTimeMillis());
            u.setName(generateRandomName());
            u.setPhoneNumber(finalPhone);
            return userRepository.save(u);
        });

        return new SmsCodeAuthenticationToken(new SecurityUser(user, roleRepository.findAllByUserId(user.getId())));
    }

    private String generateRandomName() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            sb.append((char) ('a' + Math.random() * 26));
        }
        return sb.toString();
    }
}
