package com.soufang.soufang.repository;

import com.soufang.soufang.entity.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
    Page<House> findAllByCityEnName(String cityEnName, PageRequest p);
}
