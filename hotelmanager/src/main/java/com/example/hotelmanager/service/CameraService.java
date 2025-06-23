package com.example.hotelmanager.service;

import com.example.hotelmanager.entity.Camera;
import com.example.hotelmanager.repository.CameraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraService {
    private final CameraRepository cameraRepository;

    public CameraService(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    public List<Camera> getAll() {
        return cameraRepository.findAll();
    }

    public List<Camera> getAllByPretAsc() {
        return cameraRepository.findAllByOrderByPretNoapteAsc();
    }

    public List<Camera> getAllByPretDesc() {
        return cameraRepository.findAllByOrderByPretNoapteDesc();
    }

    public Camera getById(Long id) {
        return cameraRepository.findById(id).orElse(null);
    }

    public Camera save(Camera camera) {
        return cameraRepository.save(camera);
    }

    public void delete(Long id) {
        cameraRepository.deleteById(id);
    }
}
