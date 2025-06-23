package com.example.hotelmanager.service;

import com.example.hotelmanager.entity.Hotel;
import com.example.hotelmanager.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    public Hotel getById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void delete(Long id) {
        hotelRepository.deleteById(id);
    }
    public List<Hotel> getByKeyword(String keyword) {
        return hotelRepository.findByNumeContainingIgnoreCase(keyword);
    }

}
