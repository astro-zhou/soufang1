package com.soufang.soufang.repository;

import com.soufang.soufang.entity.HouseSubscribe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseSubscribeRepository extends JpaRepository<HouseSubscribe, Long> {
    Page<HouseSubscribe> findAllByAdminIdOrderByUpdateTimeDesc(Long agentId, Pageable pageable);
}
