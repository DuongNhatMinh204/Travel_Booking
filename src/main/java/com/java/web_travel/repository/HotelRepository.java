package com.java.web_travel.repository;

import com.java.web_travel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findById(Long id);
}
