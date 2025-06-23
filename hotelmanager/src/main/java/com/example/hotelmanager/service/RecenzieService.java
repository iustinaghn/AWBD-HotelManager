package com.example.hotelmanager.service;

import com.example.hotelmanager.entity.Recenzie;
import com.example.hotelmanager.repository.RecenzieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecenzieService {
    private final RecenzieRepository recenzieRepository;

    public RecenzieService(RecenzieRepository recenzieRepository) {
        this.recenzieRepository = recenzieRepository;
    }

    public List<Recenzie> getAll() {
        return recenzieRepository.findAll();
    }

    public Recenzie getById(Long id) {
        return recenzieRepository.findById(id).orElse(null);
    }

    public Recenzie save(Recenzie recenzie) {
        return recenzieRepository.save(recenzie);
    }

    public void delete(Long id) {
        recenzieRepository.deleteById(id);
    }
}
