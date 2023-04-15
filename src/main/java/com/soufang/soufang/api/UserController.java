package com.soufang.soufang.api;

import com.soufang.soufang.base.ApiResponse;
import com.soufang.soufang.base.SecurityUser;
import com.soufang.soufang.dto.UserDTO;
import com.soufang.soufang.entity.User;
import com.soufang.soufang.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/info")
    public ApiResponse<UserDTO> getCurrentUserInfo() {
        SecurityUser principal = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();
        User user = userRepository.findByName(username).orElseThrow(() -> new IllegalStateException("用户数据异常，user: [" + username + "] 未找到"));
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user, dto);
        return ApiResponse.success(dto);
    }
}
