package com.example.hotelmanager.controller;

import com.example.hotelmanager.entity.Hotel;
import com.example.hotelmanager.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public String listHotels(@RequestParam(required = false) String keyword, Model model) {
        List<Hotel> hotels;

        if (keyword != null && !keyword.isEmpty()) {
            hotels = hotelService.getByKeyword(keyword);
        } else {
            hotels = hotelService.getAll();
        }

        model.addAttribute("hotels", hotels);
        model.addAttribute("keyword", keyword); // pentru a păstra cuvântul în input
        return "hotels"; // presupune că fișierul este hotels.html
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "add-hotel";
    }

    @PostMapping("/add")
    public String addHotel(@ModelAttribute Hotel hotel) {
        hotelService.save(hotel);
        return "redirect:/hotels";
    }

    @GetMapping("/delete/{id}")
    public String deleteHotel(@PathVariable Long id) {
        hotelService.delete(id);
        return "redirect:/hotels";
    }

    @GetMapping("/edit/{id}")
    public String editHotel(@PathVariable long id, Model model) {
        model.addAttribute("hotel", hotelService.getById(id));
        return "edit-hotel";
    }

    @PostMapping("/edit/{id}")
    public String updateHotel(@PathVariable long id, @ModelAttribute Hotel hotel) {
        hotel.setId(id);
        hotelService.save(hotel);
        return "redirect:/hotels";
    }
}
