package com.example.hotelmanager;

import com.example.hotelmanager.entity.Recenzie;
import com.example.hotelmanager.repository.RecenzieRepository;
import com.example.hotelmanager.service.RecenzieService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RecenzieServiceTest {

    // Cream un mock pentru repository
    RecenzieRepository recenzieRepository = Mockito.mock(RecenzieRepository.class);

    // Injectam repository-ul in service
    RecenzieService recenzieService = new RecenzieService(recenzieRepository);

    @Test
    void testGetById() {
        // Cream un obiect de test
        Recenzie recenzie = new Recenzie();
        recenzie.setId(1L);
        recenzie.setComentariu("Foarte bun");
        recenzie.setRating(5);

        // Cand se apeleaza findById(1), intoarce recenzia de mai sus
        when(recenzieRepository.findById(1L)).thenReturn(Optional.of(recenzie));

        // Apelam metoda din service
        Recenzie rezultat = recenzieService.getById(1L);

        // Verificam daca rezultatul este corect
        assertNotNull(rezultat);
        assertEquals("Foarte bun", rezultat.getComentariu());
        assertEquals(5, rezultat.getRating());
    }

    @Test
    void testSave() {
        Recenzie recenzie = new Recenzie();
        recenzie.setComentariu("Ok");
        recenzie.setRating(4);

        when(recenzieRepository.save(recenzie)).thenReturn(recenzie);

        Recenzie rezultat = recenzieService.save(recenzie);

        assertNotNull(rezultat);
        assertEquals("Ok", rezultat.getComentariu());
        assertEquals(4, rezultat.getRating());
    }

    @Test
    void testDelete() {
        Long id = 1L;

        // Nu returneaza nimic, dar verificam ca se apeleaza metoda deleteById
        recenzieService.delete(id);

        verify(recenzieRepository, times(1)).deleteById(id);
    }
}
