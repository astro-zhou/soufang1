package com.soufang.soufang.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soufang.soufang.entity.User;
import com.soufang.soufang.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
    private final ObjectMapper mapper;

    public WebSecurityConfiguration(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, SmsCodeFilter smsCodeFilter) throws Exception {
        http.addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeHttpRequests(h -> h.antMatchers("/api/users/**").authenticated()
                        .anyRequest().permitAll())
                .formLogin(configurer -> configurer.loginProcessingUrl("/api/sessions")
                        .successHandler(successHandler())
                        .failureHandler(failureHandler()))
                .rememberMe(c -> c.tokenValiditySeconds(3600 * 24 * 7))
                .csrf(AbstractHttpConfigurer::disable) // ajax 方法不会有 csrf 安全问题
                .logout(LogoutConfigurer::permitAll)
                .exceptionHandling(c -> c.accessDeniedHandler(accessDeniedHandler()).authenticationEntryPoint(authenticationEntryPoint()));
        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService(UserRepository repository) {
        return username -> {
            User user = repository.findByName(username).orElseThrow(() -> new UsernameNotFoundException("用户未找到"));
            return new SecurityUser(user);
        };
    }

    @Bean
    AuthenticationSuccessHandler successHandler() {
        return (request, response, authentication) -> {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(mapper.writeValueAsString(ApiResponse.success()));
        };
    }

    @Bean
    AuthenticationFailureHandler failureHandler() {
        return (request, response, exception) -> {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(mapper.writeValueAsString(ApiResponse.error(Status.ERROR_USERNAME_PASSWORD_INVALID)));
        };
    }

    @Bean
    AccessDeniedHandler accessDeniedHandler() {
        return (request, response, exception) -> {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(mapper.writeValueAsString(ApiResponse.error(Status.ERROR_FORBIDDEN)));
        };
    }

    @Bean
    AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, exception) -> {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(mapper.writeValueAsString(ApiResponse.error(Status.ERROR_NOT_LOGIN)));
        };
    }
}
