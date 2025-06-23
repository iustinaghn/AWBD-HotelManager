package com.example.hotelmanager.service;

import com.example.hotelmanager.entity.Factura;
import com.example.hotelmanager.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {
    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> getAll() {
        return facturaRepository.findAll();
    }

    public Factura getById(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    public void delete(Long id) {
        facturaRepository.deleteById(id);
    }
}
