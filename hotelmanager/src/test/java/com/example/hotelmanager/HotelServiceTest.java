package com.example.hotelmanager;

import com.example.hotelmanager.entity.Hotel;
import com.example.hotelmanager.service.HotelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HotelServiceTest {

    @Autowired
    private HotelService hotelService;

    @Test
    void testGetAllHotels() {
        // Apeleaza metoda getAll() din service
        List<Hotel> hoteluri = hotelService.getAll();

        // Verifica daca lista returnata nu este null
        assertNotNull(hoteluri, "Lista de hoteluri nu ar trebui sa fie null");
    }

    @Test
    void testAddHotel() {
        // Creeaza un hotel nou
        Hotel hotel = new Hotel();
        hotel.setNume("Hotel Test");
        hotel.setAdresa("Strada Exemplu, nr. 1");

        // Salveaza hotelul folosind service-ul
        Hotel salvat = hotelService.save(hotel);

        // Verifica daca hotelul a fost salvat si are ID
        assertNotNull(salvat.getId(), "Hotelul salvat ar trebui sa aiba un ID");
        assertEquals("Hotel Test", salvat.getNume());
    }

    @Test
    void testDeleteHotel() {
        // Creeaza si salveaza un hotel
        Hotel hotel = new Hotel();
        hotel.setNume("Hotel De Sters");
        hotel.setAdresa("Strada Test");

        Hotel salvat = hotelService.save(hotel);
        Long id = salvat.getId();

        // Sterge hotelul dupa ID
        hotelService.delete(id);

        // Verifica daca hotelul nu mai exista in lista
        List<Hotel> toate = hotelService.getAll();
        assertTrue(toate.stream().noneMatch(h -> h.getId().equals(id)), "Hotelul nu ar trebui sa mai existe");
    }
}
