package com.soufang.soufang.service;

import com.soufang.soufang.dto.HouseParams;
import com.soufang.soufang.entity.House;

public interface HouseService {
    void updateIndex(House house);

    Long create(HouseParams params);

    void delete(Long id);
}
