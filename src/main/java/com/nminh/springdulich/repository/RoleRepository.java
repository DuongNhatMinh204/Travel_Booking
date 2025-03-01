package com.nminh.springdulich.repository;

import com.nminh.springdulich.entity.Role;
import com.nminh.springdulich.enums.RoleCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleCode(RoleCode roleCode);
}
