package com.example.hotelmanager.service;

import com.example.hotelmanager.entity.Serviciu;
import com.example.hotelmanager.repository.ServiciuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciuService {

    private final ServiciuRepository serviciuRepository;

    public ServiciuService(ServiciuRepository serviciuRepository) {
        this.serviciuRepository = serviciuRepository;
    }

    public List<Serviciu> getAll() {
        return serviciuRepository.findAll();
    }

    public Serviciu getById(Long id) {
        return serviciuRepository.findById(id).orElse(null);
    }

    public Serviciu save(Serviciu serviciu) {
        return serviciuRepository.save(serviciu);
    }

    public void delete(Long id) {
        serviciuRepository.deleteById(id);
    }

    public List<Serviciu> getAllByIds(List<Long> ids) {
        return serviciuRepository.findAllById(ids);
    }
}
