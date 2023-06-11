package com.soufang.soufang.service.impl;

import com.soufang.soufang.repository.HouseRepository;
import com.soufang.soufang.service.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@ConditionalOnProperty(prefix = "app.dev", name = "init-elasticsearch", havingValue = "true")
public class ElasticsearchInitService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticsearchInitService.class);
    private final HouseService houseService;
    private final HouseRepository houseRepository;

    public ElasticsearchInitService(HouseService houseService, HouseRepository houseRepository) {
        this.houseService = houseService;
        this.houseRepository = houseRepository;
    }

    @PostConstruct
    public void syncIndex() {
        houseRepository.findAll().forEach(house -> {
            houseService.updateIndex(house);
            LOGGER.info("update index success for {}", house.getId());
        });
    }
}
