package com.example.hotelmanager;

import com.example.hotelmanager.entity.Camera;
import com.example.hotelmanager.repository.CameraRepository;
import com.example.hotelmanager.service.CameraService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CameraServiceTest {

    // Cream un mock pentru repository
    CameraRepository cameraRepository = mock(CameraRepository.class);

    // Injectam repository-ul in service
    CameraService cameraService = new CameraService(cameraRepository);

    @Test
    void testGetById() {
        // Cream o camera falsa pentru test
        Camera camera = new Camera();
        camera.setId(1L);
        camera.setTip("Single");

        // Cand apelam findById(1), sa intoarca camera de mai sus
        when(cameraRepository.findById(1L)).thenReturn(Optional.of(camera));

        // Apelam metoda din service
        Camera rezultat = cameraService.getById(1L);

        // Verificam rezultatul
        assertNotNull(rezultat);
        assertEquals("Single", rezultat.getTip());
    }

    @Test
    void testSave() {
        Camera camera = new Camera();
        camera.setTip("Double");

        // Cand se salveaza, intoarce aceeasi camera
        when(cameraRepository.save(camera)).thenReturn(camera);

        Camera rezultat = cameraService.save(camera);

        assertNotNull(rezultat);
        assertEquals("Double", rezultat.getTip());
    }

    @Test
    void testDelete() {
        Long id = 2L;

        // Apelam metoda delete
        cameraService.delete(id);

        // Verificam daca s-a apelat deleteById cu id-ul corect
        verify(cameraRepository, times(1)).deleteById(id);
    }
}
