package com.example.hotelmanager.controller;

import com.example.hotelmanager.entity.Hotel;
import com.example.hotelmanager.entity.Recenzie;
import com.example.hotelmanager.service.HotelService;
import com.example.hotelmanager.service.RecenzieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recenzii")
public class RecenzieController {

    private final RecenzieService recenzieService;
    private final HotelService hotelService;

    public RecenzieController(RecenzieService recenzieService, HotelService hotelService) {
        this.recenzieService = recenzieService;
        this.hotelService = hotelService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("recenzii", recenzieService.getAll());
        return "recenzii";
    }

    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("recenzie", new Recenzie());
        model.addAttribute("hoteluri", hotelService.getAll());
        return "add-recenzie";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Recenzie recenzie) {
        recenzieService.save(recenzie);
        return "redirect:/recenzii";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        recenzieService.delete(id);
        return "redirect:/recenzii";
    }

    @GetMapping("/edit/{id}")
    public String editRecenzie(@PathVariable long id, Model model) {
        Recenzie recenzie = recenzieService.getById(id); //
        model.addAttribute("recenzie", recenzie);
        model.addAttribute("hoteluri", hotelService.getAll());
        return "edit-recenzie"; // aa
    }

    @PostMapping("/edit/{id}")
    public String updateRecenzie(@PathVariable long id, @ModelAttribute Recenzie recenzie) {
        recenzie.setId(id);
        recenzieService.save(recenzie);
        return "redirect:/recenzii"; //
    }
}
