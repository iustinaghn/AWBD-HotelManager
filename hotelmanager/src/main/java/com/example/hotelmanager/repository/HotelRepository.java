package com.example.hotelmanager.repository;

import com.example.hotelmanager.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByNumeContainingIgnoreCase(String keyword);
}
