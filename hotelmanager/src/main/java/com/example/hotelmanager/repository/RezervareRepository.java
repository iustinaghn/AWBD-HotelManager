package com.example.hotelmanager.repository;

import com.example.hotelmanager.entity.Rezervare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezervareRepository extends JpaRepository<Rezervare, Long> {
}
