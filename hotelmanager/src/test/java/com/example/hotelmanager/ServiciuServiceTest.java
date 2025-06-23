package com.example.hotelmanager;

import com.example.hotelmanager.entity.Serviciu;
import com.example.hotelmanager.repository.ServiciuRepository;
import com.example.hotelmanager.service.ServiciuService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ServiciuServiceTest {

    // Cream un mock pentru repository
    ServiciuRepository serviciuRepository = Mockito.mock(ServiciuRepository.class);

    // Injectam repository-ul in service
    ServiciuService serviciuService = new ServiciuService(serviciuRepository);

    @Test
    void testGetById() {
        // Cream un obiect de test
        Serviciu serviciu = new Serviciu();
        serviciu.setId(1L);
        serviciu.setNume("Mic dejun");

        // Cand se apeleaza findById(1), intoarce serviciul de mai sus
        when(serviciuRepository.findById(1L)).thenReturn(Optional.of(serviciu));

        // Apelam metoda din service
        Serviciu rezultat = serviciuService.getById(1L);

        // Verificam daca rezultatul este corect
        assertNotNull(rezultat);
        assertEquals("Mic dejun", rezultat.getNume());
    }

    @Test
    void testSave() {
        Serviciu serviciu = new Serviciu();
        serviciu.setNume("Spa");

        // Cand se salveaza, intoarce acelasi obiect
        when(serviciuRepository.save(serviciu)).thenReturn(serviciu);

        Serviciu rezultat = serviciuService.save(serviciu);

        assertNotNull(rezultat);
        assertEquals("Spa", rezultat.getNume());
    }

    @Test
    void testDelete() {
        Long id = 1L;

        // Apelam metoda delete si verificam ca este chemata exact o data
        serviciuService.delete(id);

        verify(serviciuRepository, times(1)).deleteById(id);
    }
}
