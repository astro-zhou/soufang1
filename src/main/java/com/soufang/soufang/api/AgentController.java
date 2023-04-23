package com.soufang.soufang.api;

import com.soufang.soufang.base.SecurityUser;
import com.soufang.soufang.dto.HouseSubscribeDTO;
import com.soufang.soufang.service.AgentService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agents")
public class AgentController {
    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    /**
     * 获取该经纪人的预约记录
     */
    @GetMapping("/subscribes")
    public Page<HouseSubscribeDTO> getSubscribes(@AuthenticationPrincipal SecurityUser user,
                                                 @RequestParam(defaultValue = "0") Integer page,
                                                 @RequestParam(defaultValue = "10") Integer size) {

        return agentService.getSubscribes(user.getId(), page, size);
    }
}
