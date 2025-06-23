package com.example.hotelmanager;

import com.example.hotelmanager.entity.Factura;
import com.example.hotelmanager.repository.FacturaRepository;
import com.example.hotelmanager.service.FacturaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FacturaServiceTest {

    // Creeaza un mock pentru repository
    FacturaRepository facturaRepository = Mockito.mock(FacturaRepository.class);

    // Creeaza serviciul cu repository-ul fals
    FacturaService facturaService = new FacturaService(facturaRepository);

    @Test
    void testGetFacturaById() {
        // Creeaza o factura falsa
        Factura factura = new Factura();
        factura.setId(1L);
        factura.setTotal(150.00);
        factura.setDataEmitere(LocalDate.now());

        // Spune mock-ului ce sa returneze cand e apelat findById
        when(facturaRepository.findById(1L)).thenReturn(Optional.of(factura));

        // Apeleaza metoda din serviciu
        Factura rezultat = facturaService.getById(1L);

        // Verifica rezultatul
        assertNotNull(rezultat);
        assertEquals(150.00, rezultat.getTotal());
    }

    @Test
    void testSaveFactura() {
        // Creeaza o factura noua
        Factura factura = new Factura();
        factura.setTotal(200.00);

        // Simuleaza salvarea in baza de date
        when(facturaRepository.save(factura)).thenReturn(factura);

        // Apeleaza metoda save din serviciu
        Factura salvata = facturaService.save(factura);

        // Verifica daca a fost salvata corect
        assertNotNull(salvata);
        assertEquals(200.00, salvata.getTotal());
    }
}
