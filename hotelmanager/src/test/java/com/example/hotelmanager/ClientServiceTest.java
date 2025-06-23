package com.example.hotelmanager;

import com.example.hotelmanager.entity.Client;
import com.example.hotelmanager.repository.ClientRepository;
import com.example.hotelmanager.service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClientServiceTest {

    // Creeaza un mock (fals) pentru repository
    ClientRepository clientRepository = Mockito.mock(ClientRepository.class);

    // Creeaza serviciul cu mock-ul injectat
    ClientService clientService = new ClientService(clientRepository);

    @Test
    void testGetClientById() {
        // Pregateste un client fals
        Client client = new Client();
        client.setId(1L);
        client.setNume("Popescu");

        // Spune mock-ului ce sa returneze cand e apelat findById
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        // Apeleaza metoda pe care vrei sa o testezi
        Client rezultat = clientService.getById(1L);

        // Verifica daca a returnat corect
        assertNotNull(rezultat);
        assertEquals("Popescu", rezultat.getNume());
    }

    @Test
    void testSaveClient() {
        // Creeaza un client nou
        Client client = new Client();
        client.setNume("Ionescu");

        // Simuleaza salvarea clientului
        when(clientRepository.save(client)).thenReturn(client);

        // Apeleaza metoda save
        Client salvat = clientService.save(client);

        // Verifica rezultatul
        assertNotNull(salvat);
        assertEquals("Ionescu", salvat.getNume());
    }

}
