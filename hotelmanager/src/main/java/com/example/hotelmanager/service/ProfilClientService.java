package com.example.hotelmanager.service;

import com.example.hotelmanager.entity.ProfilClient;
import com.example.hotelmanager.repository.ProfilClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilClientService {
    private final ProfilClientRepository repository;

    public ProfilClientService(ProfilClientRepository repository) {
        this.repository = repository;
    }

    public List<ProfilClient> getAll() {
        return repository.findAll();
    }

    public ProfilClient getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ProfilClient save(ProfilClient profilClient) {
        return repository.save(profilClient);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
