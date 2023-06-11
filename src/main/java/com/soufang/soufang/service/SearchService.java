package com.soufang.soufang.service;

import com.soufang.soufang.dto.HouseDTO;
import com.soufang.soufang.dto.HouseSearchParams;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SearchService {
    List<String> autocompletion(String prefix);

    Page<HouseDTO> search(HouseSearchParams params);
}
