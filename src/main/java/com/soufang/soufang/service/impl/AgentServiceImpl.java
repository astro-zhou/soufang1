package com.soufang.soufang.service.impl;

import com.soufang.soufang.dto.HouseSubscribeDTO;
import com.soufang.soufang.entity.HouseSubscribe;
import com.soufang.soufang.repository.HouseSubscribeRepository;
import com.soufang.soufang.repository.UserRepository;
import com.soufang.soufang.service.AgentService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentServiceImpl implements AgentService {
    private final UserRepository userRepository;
    private final HouseSubscribeRepository houseSubscribeRepository;

    public AgentServiceImpl(UserRepository userRepository, HouseSubscribeRepository houseSubscribeRepository) {
        this.userRepository = userRepository;
        this.houseSubscribeRepository = houseSubscribeRepository;
    }

    @Override
    public Page<HouseSubscribeDTO> getSubscribes(Long agentId, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<HouseSubscribe> results = houseSubscribeRepository.findAllByAdminIdOrderByUpdateTimeDesc(agentId, pageable);
        List<HouseSubscribeDTO> content = results.stream().map(h -> {
            HouseSubscribeDTO dto = new HouseSubscribeDTO();
            BeanUtils.copyProperties(h, dto);
            return dto;
        }).collect(Collectors.toList());
        return new PageImpl<>(content, pageable, results.getTotalElements());
    }
}
