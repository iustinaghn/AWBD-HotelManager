package com.example.hotelmanager.repository;

import com.example.hotelmanager.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
