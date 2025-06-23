package com.example.hotelmanager.service;

import com.example.hotelmanager.entity.Rezervare;
import com.example.hotelmanager.repository.RezervareRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RezervareService {

    private final RezervareRepository rezervareRepository;

    public RezervareService(RezervareRepository rezervareRepository) {
        this.rezervareRepository = rezervareRepository;
    }

    public List<Rezervare> getAll() {
        return rezervareRepository.findAll();
    }

    public Rezervare getById(Long id) {
        return rezervareRepository.findById(id).orElse(null);
    }

    public Rezervare save(Rezervare rezervare) {
        return rezervareRepository.save(rezervare);
    }

    public void delete(Long id) {
        rezervareRepository.deleteById(id);
    }
}
