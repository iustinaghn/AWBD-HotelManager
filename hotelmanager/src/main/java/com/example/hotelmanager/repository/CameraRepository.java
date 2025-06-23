package com.example.hotelmanager.repository;

import com.example.hotelmanager.entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CameraRepository extends JpaRepository<Camera, Long> {

    List<Camera> findAllByOrderByPretNoapteAsc();

    List<Camera> findAllByOrderByPretNoapteDesc();
}
