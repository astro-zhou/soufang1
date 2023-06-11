package com.soufang.soufang.repository;

import com.soufang.soufang.entity.SupportAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupportAddressRepository extends JpaRepository<SupportAddress, Long> {

    List<SupportAddress> findAllByLevel(String string);

    List<SupportAddress> findAllByLevelAndBelongTo(String value, String cityName);

    SupportAddress findByEnNameAndLevel(String cityEnName, String level);
}
