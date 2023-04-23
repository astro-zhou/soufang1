package com.soufang.soufang.repository;

import com.soufang.soufang.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAllByUserId(Long userId);
}
