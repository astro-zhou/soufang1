package com.soufang.soufang.service;

import com.soufang.soufang.dto.HouseSubscribeDTO;
import org.springframework.data.domain.Page;

public interface AgentService {
    Page<HouseSubscribeDTO> getSubscribes(Long agentId, Integer page, Integer size);
}
