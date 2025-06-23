package com.example.hotelmanager.controller;

import com.example.hotelmanager.entity.Camera;
import com.example.hotelmanager.entity.Hotel;
import com.example.hotelmanager.service.CameraService;
import com.example.hotelmanager.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/camere")
public class CameraController {

    private final CameraService cameraService;
    private final HotelService hotelService;

    public CameraController(CameraService cameraService, HotelService hotelService) {
        this.cameraService = cameraService;
        this.hotelService = hotelService;
    }

    @GetMapping
    public String list(
            @RequestParam(required = false) String tip,
            @RequestParam(required = false) String sort,
            Model model
    ) {
        List<Camera> camere = cameraService.getAll();

        // Filtrare după tip (dacă e completat)
        if (tip != null && !tip.isEmpty()) {
            camere = camere.stream()
                    .filter(c -> c.getTip().toLowerCase().contains(tip.toLowerCase()))
                    .toList();
        }

        // Sortare după preț
        if ("asc".equalsIgnoreCase(sort)) {
            camere = camere.stream()
                    .sorted((c1, c2) -> Double.compare(c1.getPretNoapte(), c2.getPretNoapte()))
                    .toList();
        } else if ("desc".equalsIgnoreCase(sort)) {
            camere = camere.stream()
                    .sorted((c1, c2) -> Double.compare(c2.getPretNoapte(), c1.getPretNoapte()))
                    .toList();
        }

        model.addAttribute("camere", camere);
        return "camere";
    }

    @GetMapping("/add")
    public String form(Model model) {
        Camera camera = new Camera();
        camera.setHotel(new Hotel()); // prevenim NullPointerException
        model.addAttribute("camera", camera);
        model.addAttribute("hotels", hotelService.getAll());
        return "add-camera";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Camera camera) {
        if (camera.getHotel() == null || camera.getHotel().getId() == null) {
            throw new IllegalArgumentException("Hotelul selectat este invalid sau lipsă.");
        }

        Long hotelId = camera.getHotel().getId();
        Hotel hotelComplet = hotelService.getById(hotelId);
        camera.setHotel(hotelComplet);
        cameraService.save(camera);
        return "redirect:/camere";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        cameraService.delete(id);
        return "redirect:/camere";
    }

    @GetMapping("/edit/{id}")
    public String editCamera(@PathVariable long id, Model model) {
        Camera camera = cameraService.getById(id);
        model.addAttribute("camera", camera);
        model.addAttribute("hotels", hotelService.getAll());
        return "edit-camera";
    }

    @PostMapping("/edit/{id}")
    public String updateCamera(@PathVariable long id, @ModelAttribute Camera camera) {
        if (camera.getHotel() == null || camera.getHotel().getId() == null) {
            throw new IllegalArgumentException("Hotelul selectat este invalid sau lipsă.");
        }

        Long hotelId = camera.getHotel().getId();
        Hotel hotelComplet = hotelService.getById(hotelId);
        camera.setId(id);
        camera.setHotel(hotelComplet);
        cameraService.save(camera);
        return "redirect:/camere";
    }
}
