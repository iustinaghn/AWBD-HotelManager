package com.example.hotelmanager.repository;

import com.example.hotelmanager.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
